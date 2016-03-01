package ro.tm.siit.homework.w10d2.trainingcatalog2;

/**
 * Class to model Trainee. It extends Person
 * 
 * @author mircea
 *
 */
public class Trainee extends Person {

	/**
	 * @param grades
	 *            - stores the grades of Trainee
	 * @param msgc
	 *            - stores the message of Trainee to be send via email
	 */
	private int[] grades = new int[10];
	private int gradeCount = 0;
	private String msgc;

	/**
	 * Constructor for Trainee
	 * 
	 * @param name
	 * @param email
	 */
	public Trainee(String name, String email, String emailpass) {
		super(name, email, emailpass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * method used to set the message to be send via email
	 * 
	 * @param msgc
	 */
	public void setMsgc(String msgc) {
		this.msgc = msgc;
	}

	/**
	 * @return the message to be send via email
	 */
	public String getMsgc() {
		return msgc;
	}

	/**
	 * @param grade
	 *            adds a new grade to trainee
	 */

	public void addGrade(int grade) {
		this.grades[gradeCount++] = grade;
		setMsgc(msgTrainee(grade));
	}

	/**
	 * 
	 * @param msgt
	 * @return the message based on the grade
	 */
	public String msgTrainee(int msgt) {
		if (msgt < 7) {
			return "Why ?...For crying out loud !";
		} else if (msgt > 7 && msgt < 10) {
			return "Requesting feedback...I wish to improve my grade !";
		} else
			return "Thank you !";
	}

	/**
	 * @return a float as average of the grades
	 */
	public float getAvgGrade() {
		int sum = 0;
		for (int i = 0; i < gradeCount; i++) {
			sum += grades[i];
		}
		return ((float) sum) / gradeCount;
	}

	/**
	 * method to display grades
	 */
	public void showGrades() {
		System.out.println("Grades for " + getName() + ": ");
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] != 0)
				System.out.println(grades[i] + " ");
		}
	}

}
