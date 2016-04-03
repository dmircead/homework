
package ro.tm.siit.homework.w16d1.trainingcatalog4.catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;
import ro.tm.siit.homework.w16d1.trainingcatalog4.TraineeCatalogInterface;
import ro.tm.siit.homework.w16d1.trainingcatalog4.TrainerCatalogInterface;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Person;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Trainee;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Trainer;

/**
 * Catalog class implements TrainerCatalogInterface interface and model a grades
 * catalog for Scoala Informala de IT.
 * 
 * @author mircea
 *
 */
public final class Catalog implements TrainerCatalogInterface, TraineeCatalogInterface {

	private int traineesCount;
	private String name;
	private Messenger messenger;
	private Map<Person, List<Integer>> traineeGrades = new HashMap<>();
	private boolean startTraining = false;
	private static Catalog catalog = null;

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	private Catalog(String name, Messenger messenger) {
		super();
		this.name = name;
		this.messenger = messenger;
	}

	/**
	 * Returns the same catalog whenever is called
	 * 
	 * @param name
	 *            the name of catalog
	 * @param messenger
	 *            the messenger
	 * @return the same catalog
	 */
	public static Catalog getCatalog(String name, Messenger messenger) {
		if (catalog == null) {
			catalog = new Catalog(name, messenger);
		}
		return catalog;
	}

	/**
	 * add trainee to the catalog
	 * 
	 * @param p
	 *            the trainee for added
	 * @throws IllegalArgumentException
	 *             ,IllegalStateException
	 */
	public void addTrainee(Person p) throws IllegalArgumentException, IllegalStateException {
		if (startTraining) {
			throw new IllegalStateException("Training has started....cannot add any more trainees !");
		}
		if (traineeGrades.containsKey(p)) {
			// System.out.println("Trainee " + t + " already exist ... ");
			throw new IllegalArgumentException("Trainee " + p + " already exist ... ");
		} else {
			traineeGrades.put(p, new ArrayList<>());
			System.out.println("Trainee " + p + " added...");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#
	 * addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		try {
			if (startTraining == false) {
				throw new IllegalArgumentException("Training not started ....cannot add any grades yet ! ");
			}
			if (grade < 1 || grade > 10) {
				throw new ArithmeticException("Grade must be between 1 and 10 !");
			}
			Trainee participant = (Trainee) find(name);
			traineeGrades.get(participant).add(grade);
			System.out.println("Trainee " + participant + " received grade: " + grade);
			messenger.sendMessage(participant.getEmail(), "New grade", "Your new grade is " + grade);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		Person participant = find(name);
		for (Map.Entry<Person, List<Integer>> entry : traineeGrades.entrySet()) {
			Person key = entry.getKey();
			List<Integer> value = entry.getValue();
			System.out.println(key + " has grades: " + value);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printCatalog()
	 */
	public void printCatalog() throws IllegalStateException {
		if (startTraining) {
			Iterator<Person> iterator = traineeGrades.keySet().iterator();
			while (iterator.hasNext()) {
				Person person = iterator.next();
				System.out.println(person.getName() + " having a media of " + getAvgGrade(person.getName()));
			}
			System.out.println(this.toString() + " " + traineeGrades.size() + " ");
		} else {
			throw new IllegalStateException("Nothing to display ...Trainees have not received any grades yet !");
		}
	}

	/**
	 * Returns the last grade of the trainee
	 * 
	 * @param name
	 *            the name of the trainee
	 * @return the last grade
	 */
	@Override
	public int getLastGrade(String name) {
		Person participant = find(name);
		return traineeGrades.get(participant).get(traineeGrades.get(participant).size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catalog " + name + " has " + traineeGrades.size() + " trainees";
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @return a Trainee object or null if not found
	 */
	private Person find(String name) throws IllegalStateException {
		for (Entry<Person, List<Integer>> entry : traineeGrades.entrySet()) {
			if (entry.getKey().getName().equals(name)) {
				return entry.getKey();
			}
		}
		throw new IllegalStateException("Trainee " + name + " not found !...");

	}

	/**
	 * Defines start of the training
	 * 
	 * @param trainer
	 *            the trainer
	 */
	@Override
	public void startTraining(Trainer trainer) {
		System.out.println("Training starting ...");
		startTraining = true;

	}

	/**
	 * @return a float as average of the grades
	 */
	public float getAvgGrade(String name) {
		Person participant = find(name);
		int sum = 0;
		Iterator<Integer> iterator = traineeGrades.get(participant).iterator();
		while (iterator.hasNext()) {
			sum += iterator.next();
		}
		return ((float) sum) / traineeGrades.get(participant).size();
	}
}
