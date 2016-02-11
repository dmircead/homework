package ro.tm.siit.homework.w9d19.training;

/**
 * 
 * @author mircea
 *
 */
public interface TrainerCatalogInterface extends SiteManagerInterface {

	/**
	 * 
	 * @param name
	 * @param grade
	 * @return
	 */
	public Trainee addGrades(String name, int grade);
}
