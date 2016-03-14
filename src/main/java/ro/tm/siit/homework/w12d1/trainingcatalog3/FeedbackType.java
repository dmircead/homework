package ro.tm.siit.homework.w12d1.trainingcatalog3;

public enum FeedbackType {
	FEEDBACK1("Thank you !"), FEEDBACK2("I would like to improve my grade !"), FEEDBACK3("Please ! reduce my level of stress!");

	private String message;

	private FeedbackType(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public static String valueOfgrade(int grade) {
		if (grade < 7) {
			return FeedbackType.FEEDBACK3.getMessage();
		} else if (grade > 7 && grade < 9) {
			return FEEDBACK2.getMessage();
		} else {
			return FEEDBACK1.getMessage();
		}
		
	}

}
