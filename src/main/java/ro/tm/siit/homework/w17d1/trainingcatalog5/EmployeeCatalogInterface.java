package ro.tm.siit.homework.w17d1.trainingcatalog5;

import javax.swing.JTable;

public interface EmployeeCatalogInterface {

	/**
	 * prints to console all grades of a Trainee identified by name
	 * 
	 * @param name
	 *            the name of the trainee
	 */
	String printGrades(String name);

	/**
	 * displays all trainees with their average grade
	 */
	void printCatalog();

	/**
	 * displays all trainees with their average grade
	 * 
	 * @param tableUI
	 *            the UI component where to display
	 */
	void displayCatalog(JTable tableUI);

}