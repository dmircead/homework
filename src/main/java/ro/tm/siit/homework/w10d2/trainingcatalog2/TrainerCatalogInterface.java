package ro.tm.siit.homework.w10d2.trainingcatalog2;

public interface TrainerCatalogInterface extends SiteManagerInterface {
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
