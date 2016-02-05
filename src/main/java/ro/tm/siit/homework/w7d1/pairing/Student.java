package ro.tm.siit.homework.w7d1.pairing;

public class Student {
	private String nameStudent;
	protected Notes[] notesem;
	private int counter = 0;
	int countmedia=0;
	private float[] mediaStudents=new float[3];

	public Student(String nameStudent) {
		this.nameStudent = nameStudent;
		notesem = new Notes[2];
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public Notes[] getNotesem() {
		return this.notesem;
	}

	public float[] getMediaStudents() {
//		Arrays.sort(this.mediaStudents);
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
//		System.out.println(getMediaStudents());
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
//		System.out.println("Media cea mai mare este: "+max);
		return max;
	}
	
	
	
	/**
	 * used to set the media for each student in @param student array it calls
	 * Media() from Teacher class
	 * 
	 * @param student
	 */
	public float SetMedia() {
		float temp = 0;
		int count = 0;
		float[] mediaArr = new float[2];
		for (int i = 0; i < getNotesem().length; i++) {
			if (getNotesem()[i] != null) {
				temp = getNotesem()[i].setMedia();
				// setMedia(temp);
				mediaArr[count++] = temp;
			}

			// System.out.println(temp);
		}
		// System.out.println(Arrays.toString(mediaArr));
		return temp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNameStudent();
	}
/////////////////////////////////////////////////////////////////////////////////////////
	
}
