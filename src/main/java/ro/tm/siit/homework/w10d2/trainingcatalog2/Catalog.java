package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class Catalog implements TrainerCatalogInterface {
	private String nameCatalog;
	private Trainee trainee;
	private int traineeCount;
	private Trainee[] trainees = new Trainee[15];
	private Messager mesager;

	public Catalog(String nameCatalog) {
		super();
		this.nameCatalog = nameCatalog;
		this.mesager = new Messager(new Trainer("madalin", "dmircead@gmail.com"),
				new SiteManager("administrator", "dmircead@yahoo.com"));
	}

	public void addTrainees(String nameTrainee, String email) {
		trainees[traineeCount++] = new Trainee(nameTrainee, email);
	}

	@Override
	public void addGrade(String name, int grade) {
		// TODO Auto-generated method stub
		Trainee participant = find(name);
		participant.addGrade(grade);
		if (grade > 7 && grade < 10) {
			if (this.mesager.sendMessage(participant, mesager.getTrainerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getTrainerm(), participant, mesager.getTrainerm().sendFeedback());
		} else {
			if (this.mesager.sendMessage(participant, mesager.getTrainerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getTrainerm(), participant, mesager.getTrainerm().sendFeedback());
			if (this.mesager.sendMessage(participant, mesager.getSitemanagerm(), participant.getMsgc()))
				;
			mesager.sendMessage(mesager.getSitemanagerm(), participant, mesager.getSitemanagerm().sendFeedback());
		}
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @return a Trainee object or null if not found
	 */
	private Trainee find(String name) {
		for (Trainee t : trainees) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public void printGrades(String name) {
		// TODO Auto-generated method stub
		Trainee participant = find(name);
		participant.showGrades();
	}

	@Override
	public void printCatalog() {
		// TODO Auto-generated method stub
		System.out.println("Catalog " + this.nameCatalog + " has " + trainees.length + " trainees");
		for (Trainee t : trainees) {
			if (t != null) {
				System.out.println(t.getName() + " " + t.getAvgGrade());
			}
		}
	}

}
