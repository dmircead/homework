package ro.tm.siit.homework.w12d1.trainingcatalog3;

/**
 * enum to defines 3 types of messages to be used by class Trainee based on the
 * last grade of the Trainee
 * 
 * @author mircea
 *
 */
public enum FeedbackType {
	FEEDBACK1("Thank you !"), FEEDBACK2("I would like to improve my grade !"), FEEDBACK3(
			"Something went wrong !");

	private String message;

	/**
	 * constructor for FeedbackType enum
	 * 
	 * @param message
	 */
	private FeedbackType(String message) {
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	/**
	 * @param grade
	 *            an integer representing last grade from Trainee
	 * @return String message based on the value of grade
	 */
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
