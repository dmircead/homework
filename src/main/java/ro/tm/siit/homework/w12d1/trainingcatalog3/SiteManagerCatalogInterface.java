package ro.tm.siit.homework.w12d1.trainingcatalog3;

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

}
