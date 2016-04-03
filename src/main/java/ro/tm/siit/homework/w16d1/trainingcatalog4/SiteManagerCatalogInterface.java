package ro.tm.siit.homework.w16d1.trainingcatalog4;

import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Trainer;

/**
 * 
 * SiteManagerCatalogInterface interface it is designed to be used by the site
 * manager when accessing the catalog
 * 
 * @author mircea
 *
 */
public interface SiteManagerCatalogInterface {

	/**
	 * prints to console all grades of a Trainee identified by name
	 * 
	 * @param name
	 *            the name of the trainee
	 */
	void printGrades(String name);

	/**
	 * prints to console all trainees with their average grade
	 */
	void printCatalog();

	/**
	 * Defines the start of the training
	 * 
	 * @param trainer
	 *            the trainer
	 */
	void startTraining(Trainer trainer);

}
