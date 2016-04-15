package ro.tm.siit.homework.w17d1.trainingcatalog5;

import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * 
 * SiteManagerCatalogInterface interface it is designed to be used by the site
 * manager when accessing the catalog
 * 
 * @author mcosma
 *
 */
public interface SiteManagerCatalogInterface extends EmployeeCatalogInterface {

	/**
	 * starts the training with assigned trainer
	 * 
	 * @param trainer
	 *            the trainer
	 */
	void startTraining(Trainer trainer);

	/**
	 * stops the training
	 * 
	 */
	void stopTraining();

	/**
	 * creates the training
	 * 
	 */
	void createTraining();

	/**
	 * adds a Trainee to catalog/training
	 * 
	 * @param t
	 *            the trainee
	 */
	void addTrainee(Trainee t);

}
