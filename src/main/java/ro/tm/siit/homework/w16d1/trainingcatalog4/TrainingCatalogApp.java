/**
 * 
 */
package ro.tm.siit.homework.w16d1.trainingcatalog4;

import ro.tm.siit.homework.w16d1.trainingcatalog4.catalog.Catalog;
import ro.tm.siit.homework.w16d1.trainingcatalog4.messenger.EmailMessenger;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.SiteManager;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Trainee;
import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Trainer;

/**
 * TrainingCatalogApp class is an application for managing the catalog at Scoala
 * Informala de IT. It offers support for trainers and site managers.
 * 
 * @author mircea
 *
 */
public class TrainingCatalogApp {

	/**
	 * demo code to show how can Catalog can be used by trainers or site
	 * managers
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Messenger messenger = EmailMessenger.getMessenger();
		Catalog catalog = Catalog.getCatalog("Java S2", messenger);

		TraineeCatalogInterface traineeInterface = catalog;

		Trainee florin = new Trainee("florin", "", messenger, traineeInterface);
		Trainee radu = new Trainee("radu", "", messenger, traineeInterface);
		Trainee andrei = new Trainee("andrei", "", messenger, traineeInterface);
		Trainee ciprian = new Trainee("ciprian", "", messenger, traineeInterface);
		Trainee mircea = new Trainee("mircea", "", messenger, traineeInterface);
		Trainee maria = new Trainee("maria", "", messenger, traineeInterface);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		addTrainee(catalog, florin);
		addTrainee(catalog, mircea);
		addTrainee(catalog, ciprian);
		addTrainee(catalog, andrei);
		addTrainee(catalog, andrei);

		// trying to add grades before training started....
		work(trainer);
		// starting training ....
		siteManagerInterface.startTraining(trainer);
		// trying to add a trainee after training started...
		addTrainee(catalog, new Trainee("afterTrain", "", messenger, traineeInterface));

		work(trainer);

		ciprian.sendFeedback(trainer);
		mircea.sendFeedback(siteManager);
		siteManager.sendFeedback(trainer);

		try {
			mircea.sendFeedback(ciprian);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			trainer.sendFeedback(trainer);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * the trainer works with the catalog
	 * 
	 * @param trainer
	 */
	private static void work(Trainer trainer) {
		trainer.addGrade("florin", 10);
		trainer.addGrade("florin", 9);

		trainer.addGrade("mircea", 9);
		trainer.addGrade("mircea", 5);
		trainer.addGrade("mircea", 13);

		trainer.addGrade("andrei", 9);
		trainer.addGrade("florin", 9);

		trainer.addGrade("ciprian", 8);
		trainer.addGrade("ciprian", 9);
		trainer.addGrade("namenotexist", 7);

		trainer.printGrades("mircea");

		trainer.addGrade("mircea", 10);
		try {
			trainer.printCatalog();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * the site manager works with the catalog
	 * 
	 * @param siteManager
	 */
	private static void work(SiteManager siteManager) {
		siteManager.printGrades("mircea");
		// siteManager.printCatalog();
		try {
			siteManager.printCatalog();
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());

		}

	}

	private static void addTrainee(Catalog catalog, Trainee trainee) {
		try {
			catalog.addTrainee(trainee);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
