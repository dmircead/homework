package ro.tm.siit.homework.w16d1.trainingcatalog4;

/**
 * TraineeCatalogInterface interface implements catalog designed to give the
 * last grade of the trainee
 * 
 * @author Mircea
 *
 */
public interface TraineeCatalogInterface {
	/**
	 * gets the last grade of the trainee
	 * 
	 * @param name
	 *            the trainee name
	 * @return the lsat grade of the trainee
	 */
	int getLastGrade(String name);

}