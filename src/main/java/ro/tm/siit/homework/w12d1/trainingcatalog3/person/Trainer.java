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

	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.trainerInterface = trainer;
	}

	public void addGrade(String string, int grade) {
		trainerInterface.addGrade(string, grade);
	}

	public void printGrades(String string) {
		trainerInterface.printGrades(string);
		
	}

	public void printCatalog() {
		trainerInterface.printCatalog();
	}

	@Override
	public void sendFeedback(Person to) {
		if (checkPersonType(to)){
			messenger.sendMessage(to.getEmail(), "my feed", "...");
		}
//		messenger.sendMessage(to.getEmail(), "my feed", "...");
	}

}
