package ro.tm.siit.homework.w17d1.trainingcatalog5;

import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * 
 * SiteManagerCatalogInterface interface it is designed to be used by the site manager when accessing the catalog
 * @author mcosma
 *
 */
public interface SiteManagerCatalogInterface {

	/**
	 * prints to console all grades of a Trainee identified by name
	 * @param name the name of the trainee
	 */
	void printGrades(String name);
	
	/**
	 * prints to console all trainees with their average grade
	 */
	void printCatalog();
	
	/**
	 * starts the training with assigned trainer
	 * @param trainer the trainer
	 */
	void startTraining(Trainer trainer);
	
	/**
	 * adds a Trainee to catalog/training
	 * 
	 * @param t
	 *            the trainee
	 */
	void addTrainee(Trainee t);

}
