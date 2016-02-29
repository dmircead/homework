package ro.tm.siit.homework.w9d19.training;

public class CatalogApp {

	public static void main(String[] args) {
		Catalog catalog = new Catalog();
		
		catalog.createParticipants();
		Trainee ct = new Trainee();
		catalog.printParticipants();
		ct.addGrades("Participant 1", 8);
		ct.addGrades("Participant 2", 2);
		ct.addGrades("Participant 1", 4);
		ct.addGrades("Participant 3", 5);
		ct.addGrades("Participant 4", 3);
		ct.addGrades("Participant 1", 6);
		ct.addGrades("Participant 5", 9);
		ct.addGrades("Participant 1", 1);
		ct.addGrades("Participant 3", 7);
		
		catalog.printGrades();
		ct.printParticipantGrade("Participant 1");
		catalog.printMedia();
		Catalog cat = new Catalog();
		cat.printGrades();
	}

}
