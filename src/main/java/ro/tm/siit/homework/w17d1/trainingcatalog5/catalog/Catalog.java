/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5.catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TraineeCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TrainerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;



/**
 * Catalog class implements TrainerCatalogInterface interface and model a grades
 * catalog for Scoala Informala de IT.
 * 
 * @author mcosma
 *
 */
public final class Catalog  implements TrainerCatalogInterface, TraineeCatalogInterface, Serializable {

	private static Catalog instance;

	private Map<Trainee, List<Integer>> trainees = new HashMap<Trainee, List<Integer>>();
	private String name;
	private Messenger messenger;
	private boolean started = false;
	private Trainer trainer;

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	private Catalog(String name, Messenger messenger, Trainee... trainees) {
		super();
		this.name = name;
		for (Trainee t : trainees) {
			this.trainees.put(t, new ArrayList<Integer>());
		}
		this.messenger = messenger;
	}

	/**
	 * singleton method to ensure only one catalog exists
	 * 
	 * @param name
	 *            the name of course
	 * @param messenger
	 *            the messenger that notifies students
	 * @return a Catalog instance
	 */
	public static Catalog getInstance(String name, Messenger messenger) {
		if (instance == null) {
			instance = new Catalog(name, messenger);
		}
		return instance;
	}

	/**
	 * adds a Trainee to catalog
	 * 
	 * @param t
	 *            the trainee
	 */
	public void addTrainee(Trainee t) {
		if (started) {
			throw new IllegalStateException("training already started");
		}
		this.trainees.put(t, new ArrayList<Integer>());
	}

	@Override
	public void startTraining(Trainer trainer) {
		this.started = true;
		this.trainer = trainer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#
	 * addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		if (!started) {
			throw new IllegalStateException("training not started");
		}
		if (grade < 0 || grade > 10) {
			throw new IllegalArgumentException("grade is not allowed: " + grade);
		}
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		list.add(grade);
		messenger.sendMessage(participant.getEmail(), "New grade from " + trainer.getName(),
				"Your new grade is " + grade);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		if (!started) {
			throw new IllegalStateException("training not started");
		}
		Trainee participant = find(name);
		System.out.println(getTraineeGrades(participant));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printCatalog()
	 */
	public void printCatalog() {
		if (!started) {
			throw new IllegalStateException("training not started");
		}
		System.out.println("Catalog " + name + " has " + trainees.size() + " trainees");
		for (Trainee trainee : trainees.keySet()) {
			System.out.println(trainee.getName() + " " + getAvgGrade(trainee));
		}

	}

	@Override
	public int getLastGrade(String name) {
		if (!started) {
			throw new IllegalStateException("training not started");
		}
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		if (list.isEmpty()) {
			throw new IllegalStateException("trainee has no grade: " + name);
		}
		return list.get(list.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catalog " + name + " has " + trainees.size() + " trainees";
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name fo the trainee
	 * @return a Trainee object or null if not found
	 */
	private Trainee find(String name) {
		for (Trainee t : trainees.keySet()) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		throw new IllegalArgumentException("no Trainee found with name " + name);
	}

	/**
	 * @param trainee
	 *            the trainee for which to calculate avg grade
	 * @return a float as average of the grades
	 */
	public float getAvgGrade(Trainee trainee) {
		int sum = 0;
		List<Integer> list = trainees.get(trainee);
		for (Integer i : list) {
			sum += i;
		}
		return ((float) sum) / list.size();
	}

	/**
	 * returns a string with name and the grades of this trainee
	 * 
	 * @param trainee
	 * @param list
	 * @return
	 */
	private String getTraineeGrades(Trainee trainee) {
		List<Integer> list = trainees.get(trainee);
		String out = trainee.getName() + " : ";
		for (Integer i : list) {
			out += i + " ";
		}
		return out;
	}
	
	public List<Trainee> traineesForGui(){
		List<Trainee> keyList = new ArrayList<Trainee>(trainees.keySet());
		return keyList;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public Map<Trainee, List<Integer>> getTrainees() {
		return trainees;
	}
	
	public void saveToFile(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(getTrainer());
		
	}
	
	public void loadFile(File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ooi = new ObjectInputStream(fis);
		
		try {
			this.trainees = (Map<Trainee, List<Integer>>) ooi.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
