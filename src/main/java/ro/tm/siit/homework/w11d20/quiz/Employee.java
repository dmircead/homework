package ro.tm.siit.homework.w11d20.quiz;

public class Employee extends Person implements Succes {
	
	int salary;
	int experience;
	int index;
	String name;
	
	public Employee(String nume,int salary, int experience) {
		super(nume);
		this.salary = salary;
		this.experience = experience;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public int index() {
		index = getSalary() / getExperience();
		return index;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
