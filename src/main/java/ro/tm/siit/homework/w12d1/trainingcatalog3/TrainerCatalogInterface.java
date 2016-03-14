package ro.tm.siit.homework.w12d1.trainingcatalog3;

/**
 * TrainerCatalogInterface interface extends SiteManagerCatalogInterface and it
 * is designed to give extended access to the trainers when working with a
 * catalog
 * 
 * @author mcosma
 *
 */
public interface TrainerCatalogInterface extends SiteManagerCatalogInterface {

	/**
	 * adds a grade to a Trainee
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param grade
	 *            the grade
	 */
	void addGrade(String name, int grade);
	
}
