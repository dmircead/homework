package ro.tm.siit.homework.w16d1.trainingcatalog4.person;

import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;
import ro.tm.siit.homework.w16d1.trainingcatalog4.SiteManagerCatalogInterface;

/**
 * Class SiteManager extends Person models a site manager
 * 
 * @author Mircea
 */
public class SiteManager extends Person {

	private SiteManagerCatalogInterface siteManagerInterface;

	/**
	 * Constructor for the site manager
	 * 
	 * @param name
	 *            the name of the site manager
	 * @param email
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
	 * 
	 */
	public void printCatalog() {
		siteManagerInterface.printCatalog();
	}

	/**
	 * Defines the start of the training
	 * 
	 * @param trainer
	 *            the trainer
	 */
	public void startTraining(Trainer trainer) {
		siteManagerInterface.startTraining(trainer);
	}
}
