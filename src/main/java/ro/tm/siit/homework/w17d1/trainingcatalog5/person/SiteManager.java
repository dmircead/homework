package ro.tm.siit.homework.w17d1.trainingcatalog5.person;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.SiteManagerCatalogInterface;

public class SiteManager extends Person {

	private SiteManagerCatalogInterface siteManagerInterface;

	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.siteManagerInterface = siteManager;
	}

	public void printGrades(String string) {
		siteManagerInterface.printGrades(string);

	}

	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}
	
	public void startTraining(Trainer trainer) {
		siteManagerInterface.startTraining(trainer);
	}
	
	public void addTrainee(Trainee trainee) {
		siteManagerInterface.addTrainee(trainee);
	}

}
