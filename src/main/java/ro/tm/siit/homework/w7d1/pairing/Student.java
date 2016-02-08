package ro.tm.siit.homework.w7d1.pairing;

public class Student {
	private String nameStudent;
	private Notes[] notesem;
	private int counter = 0;
	int countmedia=0;
	Classroom  csem;
	private float[] mediaStudents=new float[3];

	public Student(String nameStudent) {
		this.nameStudent = nameStudent;
		notesem = new Notes[3];
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public Notes[] getNotesem() {
		return this.notesem;
	}

	public float[] getMediaStudents() {
		return this. mediaStudents;
	}

	public void setMediaStudents() {
		this.mediaStudents[countmedia++] = SetMedia();
	}

	public void addNotes(Notes noteadd) {
		notesem[counter++] = noteadd;
	}

	public void printNotesArray() {
		int semS=0;
		for (int i = 0; i < getNotesem().length; i++) {
			if (getNotesem()[i] != null) {
				System.out.println(getNotesem()[semS]);
				System.out.println("for semester "+(semS+1));
			}
			semS++;
		}
	}

	public void printMedia() {
			for (int j = 0; j < getMediaStudents().length; j++) {
					if (getMediaStudents()[j] != 0) {
						System.out.println(getMediaStudents()[j]);
					}
				}
			}
	public float mediaSem(int sem){
		if(sem==1){
			
		return getMediaStudents()[0];
		}else if(sem==2){
			return getMediaStudents()[1];
		}else{
			return getMediaStudents()[2];
		}
	}
		
	public float getMaxMedia(){
		float max=getMediaStudents()[0];
		for(int i=0; i<getMediaStudents().length;i++){
			if (getMediaStudents()[i]>max)
				max=getMediaStudents()[i];
		}
		return max;
	}
	
	/**
	 * 
	 * 
	 * @param student
	 */
	public float SetMedia() {
		float temp = 0;
		int count = 0;
		float[] mediaArr = new float[getNotesem().length];
		for (int i = 0; i < getNotesem().length; i++) {
			if (getNotesem()[i] != null) {
				temp = getNotesem()[i].setMedia();
				mediaArr[count++] = temp;
			}
		}
		return temp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNameStudent();
	}
/////////////////////////////////////////////////////////////////////////////////////////
	
}
