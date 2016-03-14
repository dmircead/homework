package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;
import ro.tm.siit.homework.w12d1.trainingcatalog3.SiteManagerCatalogInterface;

/**
 * Class SiteManager extends Person models a site manager
 * 
 * @author mircea
 *
 */
public class SiteManager extends Person {

	private SiteManagerCatalogInterface siteManagerInterface;

	/**
	 * Constructor for the site manager
	 * 
	 * @param name
	 *            the name of the site manager
	 * @param emailAddress
	 *            the email address of the site manager
	 * @param siteManager
	 *            the site manager interface
	 * @param messager
	 *            the messenger
	 */
	public SiteManager(String name, String email, SiteManagerCatalogInterface siteManager, Messenger messenger) {
		super(name, email, messenger);
		this.siteManagerInterface = siteManager;
	}

	/**
	 * prints the trainee grades
	 * 
	 * @param string
	 *            the name of the trainee
	 */
	public void printGrades(String string) {
		siteManagerInterface.printGrades(string);

	}

	/**
	 * prints all the trainee with their average
	 */
	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}

	@Override
	public void sendFeedback(Person to) {
		super.sendFeedback(to);
		if (isSendIt()){
			messenger.sendMessage(to.getEmail(), "my feed", "...");
		}
	}

}
