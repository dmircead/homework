package ro.tm.siit.homework.w9d19.training;

public class Trainee extends Catalog implements TrainerCatalogInterface {
	/**
	 * Class Trainee it adds grades to participants
	 */

	@Override
	public Trainee addGrades(String name, int grade) {
		for (int i = 0; i < getParticipants().length; i++) {
			if (getParticipants()[i].equals(name)) {
				getGrades()[count++] = grade;

			}

		}
		return this;

	}
}
