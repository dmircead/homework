package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class Person {
	private String name;
	private String email;
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email=email;
	}

	public String getName() {
		return name;
	}
	
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return this.name;
	}



}
