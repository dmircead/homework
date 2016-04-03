/**
 * 
 */
package ro.tm.siit.homework.w16d1.trainingcatalog4.person;

import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;
//import ro.tm.siit.homework.w16d1.trainingcatalog4.SiteManagerCatalogInterface;
import ro.tm.siit.homework.w16d1.trainingcatalog4.TrainerCatalogInterface;

/**
 * Class Trainer who extends Person models a trainer
 * 
 * @author Mircea
 *
 */
public class Trainer extends Person {

	private TrainerCatalogInterface trainerInterface;

	/**
	 * Constructor for the trainer
	 * 
	 * @param name
	 *            the name of the trainer
	 * @param emailAddress
	 *            the email address of the trainer
	 * @param trainer
	 *            the trainer interface
	 * @param messager
	 *            the messenger
	 */
	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.trainerInterface = trainer;
	}

	/**
	 * Method to add grades to trainee by trainer
	 * 
	 * @param grade
	 *            adds a grade to trainee
	 * @param string
	 *            the name of trainee
	 */
	public void addGrade(String string, int grade) {
		trainerInterface.addGrade(string, grade);
	}

	/**
	 * prints the trainee grades
	 * 
	 * @param string
	 *            the name of the trainee
	 */
	public void printGrades(String string) {
		trainerInterface.printGrades(string);

	}

	/**
	 * prints all the trainee with their average
	 * 
	 */
	public void printCatalog() {
		trainerInterface.printCatalog();
	}

}
