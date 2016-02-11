package ro.tm.siit.homework.w9d19.training;

public class CatalogApp {

	public static void main(String[] args) {
		Catalog catalog = new Catalog();

		Trainee t = new Trainee();
		t.addGrades("Participant 1", 8).addGrades("Participant 1", 9).addGrades("Participant 1", 7);
		t.printGrades();
		t.printParticipants();
	}

}
