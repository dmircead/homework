package ro.tm.siit.homework.w10d2.trainingcatalog2;

public interface SiteManagerInterface {
	/**
	 * prints to console all grades of a Trainee identified by name
	 * @param name the name of the trainee
	 */
	void printGrades(String name);
	
	/**
	 * prints to console all trainees with their average grade
	 */
	void printCatalog();

}
