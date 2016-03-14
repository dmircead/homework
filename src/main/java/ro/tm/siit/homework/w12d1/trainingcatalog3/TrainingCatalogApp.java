/**
 * 
 */
package ro.tm.siit.homework.w12d1.trainingcatalog3;

import ro.tm.siit.homework.w12d1.trainingcatalog3.catalog.Catalog;
import ro.tm.siit.homework.w12d1.trainingcatalog3.messenger.EmailMessenger;
import ro.tm.siit.homework.w12d1.trainingcatalog3.person.SiteManager;
import ro.tm.siit.homework.w12d1.trainingcatalog3.person.Trainee;
import ro.tm.siit.homework.w12d1.trainingcatalog3.person.Trainer;

/**
 * TrainingCatalogApp class is an application for managing the catalog at Scoala
 * Informala de IT. It offers support for trainers and site managers.
 * 
 * @author mcosma
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
		Messenger messenger = new EmailMessenger();
		Catalog catalog = new Catalog("Java S2", messenger);
		TraineeCatalogInterface traineeInterface = catalog;
		Trainee mircea = new Trainee("mircea", "dmircead@gmail.com", messenger,traineeInterface);
//		Trainee radu = new Trainee("radu", "dmircead@gmail.com", messenger,traineeInterface);
//		Trainee andrei = new Trainee("andrei", "dmircead@gmail.com", messenger,traineeInterface);
//		Trainee ciprian = new Trainee("ciprian", "dmircead@gmail.com", messenger,traineeInterface);
		
		catalog.addTrainee(mircea);
//		catalog.addTrainee(radu);
//		catalog.addTrainee(andrei);
//		catalog.addTrainee(ciprian);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "dmircead@gmail.com", trainerInterface, messenger);
		work(trainer);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "dmircead@gmail.com", siteManagerInterface, messenger);
		work(siteManager);

		
		trainer.sendFeedback(mircea);
		mircea.sendFeedback(siteManager);
		trainer.sendFeedback(siteManager);
		
		//ciprian.sendFeedback(radu);
		//ciprian.sendFeedback(ciprian);

	}

	/**
	 * the trainer works with the catalog
	 * 
	 * @param trainer
	 */
	private static void work(Trainer trainer) {
		trainer.addGrade("mircea", 10);
		trainer.addGrade("mircea", 9);

//		trainer.addGrade("radu", 9);
//		trainer.addGrade("radu", 10);
//
//		trainer.addGrade("andrei", 9);
//		trainer.addGrade("florin", 9);
//
//		trainer.addGrade("ciprian", 8);
//		trainer.addGrade("ciprian", 9);

		trainer.printGrades("mircea");

		trainer.addGrade("mircea", 8);
		trainer.printCatalog();
	}

	/**
	 * the site manager works with the catalog
	 * 
	 * @param siteManager
	 */
	private static void work(SiteManager siteManager) {
		siteManager.printGrades("mircea");
		siteManager.printCatalog();
	}
	
	public static void sendFeed(Trainee trainee, TraineeCatalogInterface tci){

	}

}
