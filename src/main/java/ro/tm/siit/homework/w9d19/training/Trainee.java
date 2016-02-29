package ro.tm.siit.homework.w9d19.training;

/**
 * Class Trainee it adds grades to participants
 */

public class Trainee extends Catalog implements TrainerCatalogInterface {
	/**
	 * method to add Grades based on @param name and grade it adds them to
	 * Grades[] from Participant class
	 */
	@Override
	public void addGrades(String name, int grade) {

		for (int i = 0; i < getParticipants().length; i++) {
			if (getParticipants()[i].count < getParticipants()[i].getGrades().length
					&& getParticipants()[i].getName().equals(name)) {
				getParticipants()[i].getGrades()[getParticipants()[i].count++] = grade;
				System.out.println("Added grade "+grade+" for " + getParticipants()[i]);
			}
		}
	}

}
