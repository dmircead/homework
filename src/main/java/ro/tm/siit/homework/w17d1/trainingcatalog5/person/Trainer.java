/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5.person;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TrainerCatalogInterface;

/**
 * @author mco
 *
 */
public class Trainer extends Person {

	private TrainerCatalogInterface trainerInterface;

	public Trainer(String name, String email, TrainerCatalogInterface trainer, Messenger messenger) {
		super(name, email, messenger);
		this.trainerInterface = trainer;
	}

	public void addGrade(String string, int grade) {
		trainerInterface.addGrade(string, grade);
	}

	public String printGrades(String string) {
		return trainerInterface.printGrades(string);

	}

	public void printCatalog() {
		trainerInterface.printCatalog();
	}

	public void displayCatalog(JTable catalog) {
		trainerInterface.displayCatalog(catalog);
	}
	
	public DefaultTableModel gradesTableModel(String string, JTable jtable){
		return trainerInterface.gradesTableModel(string, jtable );
	}
}
