package ro.tm.siit.homework.w17d1.trainingcatalog5.person;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.SiteManagerCatalogInterface;

public class SiteManager extends Person {

	private SiteManagerCatalogInterface siteManagerInterface;

	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.siteManagerInterface = siteManager;
	}

	public String printGrades(String string) {
		return siteManagerInterface.printGrades(string);

	}

	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}

	public void startTraining(Trainer trainer) {
		siteManagerInterface.startTraining(trainer);
	}

	public void stopTraining() {
		siteManagerInterface.stopTraining();
	}
	public void createTraining(){
		siteManagerInterface.createTraining();
	}
	public void addTrainee(Trainee trainee) {
		siteManagerInterface.addTrainee(trainee);
	}

}
