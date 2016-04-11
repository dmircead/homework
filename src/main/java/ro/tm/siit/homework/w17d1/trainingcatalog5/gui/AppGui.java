package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.SiteManagerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TraineeCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TrainerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog5.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

public class AppGui {

	public static void main(String[] args) {
		Messenger messenger = SimpleMessenger.getInstance();
		Catalog catalog = Catalog.getInstance("Java S2", messenger);

		TraineeCatalogInterface traineeInterface = catalog;
		Trainee florin = new Trainee("florin", "", messenger, traineeInterface);
		Trainee radu = new Trainee("radu", "", messenger, traineeInterface);
		Trainee andrei = new Trainee("andrei", "", messenger, traineeInterface);
		Trainee ciprian = new Trainee("ciprian", "", messenger, traineeInterface);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		siteManager.addTrainee(florin);
		siteManager.addTrainee(radu);
		siteManager.addTrainee(andrei);
		siteManager.addTrainee(ciprian);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);
		try {
			trainer.addGrade("florin", 10);
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}

		try {
			siteManager.printGrades("florin");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}

		siteManager.startTraining(trainer);
		work(trainer);
		new MainFrame(catalog);
	}
	/**
	 * the trainer works with the catalog
	 * 
	 * @param trainer
	 */
	private static void work(Trainer trainer) {
		trainer.addGrade("florin", 10);
		trainer.addGrade("florin", 9);

		try {
			trainer.addGrade("dana", 4);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		trainer.addGrade("radu", 9);
		trainer.addGrade("radu", 10);

		trainer.addGrade("andrei", 9);
		trainer.addGrade("florin", 9);

		try {
			trainer.addGrade("florin", 11);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		trainer.addGrade("ciprian", 8);
		trainer.addGrade("ciprian", 9);

		trainer.printGrades("radu");

		trainer.addGrade("radu", 10);
		trainer.printCatalog();
	}

	/**
	 * the site manager works with the catalog
	 * 
	 * @param siteManager
	 */
	private static void work(SiteManager siteManager) {
		siteManager.printGrades("radu");
		siteManager.printCatalog();
	}

}
