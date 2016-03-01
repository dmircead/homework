package ro.tm.siit.homework.w10d2.trainingcatalog2;

/**
 * Class to model super class Person
 * 
 * @author mircea
 *
 */
public class Person {
	private String name;
	private String email;
	private String emailpass;

	/**
	 * Constructor for class Person
	 * 
	 * @param name
	 * @param email
	 */
	public Person(String name, String email, String emailpass) {
		super();
		this.name = name;
		this.email = email;
		this.emailpass = emailpass;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmailpass(String emailpass) {
		this.emailpass = emailpass;
	}

	public String getEmailpass() {
		return emailpass;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
