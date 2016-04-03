package ro.tm.siit.homework.w16d1.trainingcatalog4.person;

/**
 * it defines three types of the feedback
 * 
 * @author Mircea
 *
 */
public enum FeedbackType {

	HighSatistfaction((byte) 9, "I'm very happy. 10x!!!"), AverageSatisfaction((byte) 7,
			"I suppose it is ok."), BelowSatisfaction((byte) 0, "Not happy with my rating!");

	private byte minGrade;
	private String feedbackMsg;

	/**
	 * Constructor for the enum FeedbackType
	 * 
	 * @param message
	 *            the message for this type of feedback
	 */
	private FeedbackType(byte minGrade, String feedbackMsg) {
		this.minGrade = minGrade;
		this.feedbackMsg = feedbackMsg;
	}

	/**
	 * gets the message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return feedbackMsg;
	}

	/**
	 * returns the enum feedbackType for a some grade
	 * 
	 * @param grade
	 *            the grade
	 * @return the feedbackType
	 */
	public static FeedbackType valueOfGrade(int grade) {
		for (FeedbackType type : values()) {
			if (grade >= type.minGrade) {
				return type;
			}
		}
		throw new IllegalArgumentException("no FeedbackType for " + grade);
	}

}
