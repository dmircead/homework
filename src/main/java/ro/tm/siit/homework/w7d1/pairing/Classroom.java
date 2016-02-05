package ro.tm.siit.homework.w7d1.pairing;

public class Classroom {
	private static Student[] studentsPresent = new Student[2];
	private Teacher teacher;
	private Course course;
	private int semester;

	public Classroom(int sem) {
		teacher = new Teacher("Madalin");
		course = new Course("Java");
		this.semester=sem;
		System.out.println("Semester: "+sem);
	}
	
	public static Student[] getStudentsPresent() {
		return studentsPresent;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Course getCourse() {
		return course;
	}

	public int getSem() {
		return semester;
	}

	public static Student[] initStudents() {
		for (int i = 0; i < getStudentsPresent().length; i++) {
			getStudentsPresent()[i] = new Student(String.valueOf(i + 1));
		}
		System.out.println("There are " + getStudentsPresent().length + " students present in class...");
		return getStudentsPresent();
	}

	public void examStudents() {
		for (int i = 0; i < getStudentsPresent().length; i++) {
			System.out.println("The students are being examined...");
			System.out.println("Input notes for student " + getStudentsPresent()[i].getNameStudent() + ": ");
			Notes note = new Notes(getTeacher(), getCourse());
			getStudentsPresent()[i].addNotes(note);
		}

	}

	public void media() {
		for (int i = 0; i < getStudentsPresent().length; i++) {
			getStudentsPresent()[i].setMediaStudents();
		}
	}

	public void catalog() {
		for (int i = 0; i < studentsPresent.length; i++) {
			System.out.println("Notes for student " + getStudentsPresent()[i].getNameStudent() + " are:");
			getStudentsPresent()[i].printNotesArray();
		}
	}

	public void printMedii() {
		float max = getStudentsPresent()[0].getMaxMedia();
		for (int i = 0; i < studentsPresent.length; i++) {
			System.out.println("Media pentru studentul " + getStudentsPresent()[i] + " este: ");
			getStudentsPresent()[i].printMedia();
			if (getStudentsPresent()[i].getMaxMedia() > max)
				max = getStudentsPresent()[i].getMaxMedia();
		}
	}

	public void printMediaSem() {
		for (int i = 0; i < getStudentsPresent().length; i++) {
			System.out
					.println("Media pentru studentul " + getStudentsPresent()[i] + " pe semestrul " + getSem() + " este: ");
			System.out.println(getStudentsPresent()[i].mediaSem(getSem()));

			if(getSem()>1){
				if(getStudentsPresent()[i].mediaSem(getSem())>getStudentsPresent()[i].mediaSem(getSem()-1)){
					System.out.println("Student "+getStudentsPresent()[i]+" has made a progress...");
				}else{
					System.out.println("Student "+getStudentsPresent()[i]+" has not made any progress...");
				}
			}
		}
	}

	public void  rankTeacher() {
		int ind=0;
		float[] temp = new float[3];
		float suma=0;
		for (int i = 0; i < getStudentsPresent().length; i++) {
		
			suma+=getStudentsPresent()[i].mediaSem(getSem());
		
		}
		
		temp[ind++]=suma;
		for(int j=0; j<temp.length;j++){
			if(!(temp[j]==0)){
			System.out.println("Teacher rank is: "+temp[j]+" for semester "+getSem());
			}
		}
		
		if(getSem()>1&&getSem()<3){
			if (temp[1]>temp[0]){
				System.out.println("Teacher rank has increased...from semester "+(getSem()-1));
			}else{
				System.out.println("Teacher rank has decreased...from semester "+(getSem()-1));
			}
			
		}
		if(getSem()>2){
			if (temp[2]>temp[1]){
				System.out.println("Teacher rank has increased...from semester "+(getSem()-1));
			}else{
				System.out.println("Teacher rank has decreased...from semester "+(getSem()-1));
			}
		}
	}
}
