package ro.tm.siit.homework.w17d1.trainingcatalog5;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * TrainerCatalogInterface interface extends SiteManagerCatalogInterface and it
 * is designed to give extended access to the trainers when working with a
 * catalog
 * 
 * @author mcosma
 *
 */
public interface TrainerCatalogInterface extends EmployeeCatalogInterface {

	/**
	 * adds a grade to a Trainee
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param grade
	 *            the grade
	 */
	void addGrade(String name, int grade);
	
	 DefaultTableModel gradesTableModel(String string, JTable jtable);

}
