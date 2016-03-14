package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;
import ro.tm.siit.homework.w12d1.trainingcatalog3.SiteManagerCatalogInterface;

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

	@Override
	public void sendFeedback(Person to) {
		messenger.sendMessage(to.getEmail(), "my feed", "...");
	}

}
