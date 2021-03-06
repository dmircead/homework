package ro.tm.siit.homework.w10d2.trainingcatalog2;

/**
 * Class to model catalog Method receives an object of type Messager wich
 * instantiate via constructor It allows to display trainees via interface
 * SiteManagerInterface and to add grades to trainee via interface
 * TrainerCatalogInterface When adding grade it sends messages through Messager
 * object via email from Trainee to Trainer and SiteManager and reversed based
 * on the grade
 * 
 * @author mircea
 *
 */
public class Catalog implements TrainerCatalogInterface {
	/**
	 * @param trainees
	 *            array to store trainees
	 * @mesager - it is instantiated in constructor and used in method addGrade
	 */
	private String nameCatalog;
	private Trainee trainee;
	private int traineeCount;
	private Trainee[] trainees = new Trainee[15];
	private Messager mesager;

	/**
	 * Constructor for catalog it instantiate an object of type Messager -
	 * mesager
	 */
	public Catalog(String nameCatalog) {
		super();
		this.nameCatalog = nameCatalog;
		this.mesager = new Messager(new Trainer("madalin", "dmircead@gmail.com", " "),
				new SiteManager("administrator", "dmircead@gmail.com"," "));
	}

	/**
	 * Method to add Trainees to trainees array
	 * 
	 * @param nameTrainee
	 * @param email
	 */
	public void addTrainees(String nameTrainee, String email, String emailpass) {
		trainees[traineeCount++] = new Trainee(nameTrainee, email, emailpass);
	}

	/**
	 * Method to add grades to Trainees via interface TrainerCatalogInterface
	 * also sends messages based on the grade via mesager object
	 */
	@Override
	public void addGrade(String name, int grade) {
		// TODO Auto-generated method stub
		Trainee participant = find(name);
		participant.addGrade(grade);
		if (grade > 7 && grade < 10) {
			if (this.mesager.sendMessage(participant, mesager.getTrainerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getTrainerm(), participant, mesager.getTrainerm().sendFeedback());
		} else {
			if (this.mesager.sendMessage(participant, mesager.getTrainerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getTrainerm(), participant, mesager.getTrainerm().sendFeedback());
			if (this.mesager.sendMessage(participant, mesager.getSitemanagerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getSitemanagerm(), participant, mesager.getSitemanagerm().sendFeedback());
		}
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @return a Trainee object or null if not found
	 */
	private Trainee find(String name) {
		for (Trainee t : trainees) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * method to print grades from Trainees
	 */
	@Override
	public void printGrades(String name) {
		// TODO Auto-generated method stub
		Trainee participant = find(name);
		participant.showGrades();
	}

	/**
	 * method to print name of catalog and average from trainees
	 */
	@Override
	public void printCatalog() {
		// TODO Auto-generated method stub
		System.out.println("Catalog " + this.nameCatalog + " has " + trainees.length + " trainees");
		for (Trainee t : trainees) {
			if (t != null) {
				System.out.println(t.getName() + " " + t.getAvgGrade());
			}
		}
	}

}
