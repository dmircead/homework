/**
 * 
 */
package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;
import ro.tm.siit.homework.w12d1.trainingcatalog3.TrainerCatalogInterface;

/**
 * @author mco
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
     * adds grade to trainee
     * 
     * @param string
     *            the trainee name
     * @param grade
     *            the grade
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
     */
	public void printCatalog() {
		trainerInterface.printCatalog();
	}
    
	
	@Override
	public void sendFeedback(Person to) {
		super.sendFeedback(to);
		if (isSendIt()){
			messenger.sendMessage(to.getEmail(), "my feed", "...");
		}
	}

}
