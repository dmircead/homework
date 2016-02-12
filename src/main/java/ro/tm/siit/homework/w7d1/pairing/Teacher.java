package ro.tm.siit.homework.w7d1.pairing;

public class Teacher {
	private String nameTeacher;
	private float[] noteTeacher;
	private int countMedii=0;
	private float[] ranks=new float[Classroom.getSem()];
	
	public Teacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
		this.noteTeacher = new float[2];
		System.out.println("Teacher "+nameTeacher+" has entered the class...");
	}

	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w7d1.pairing.rankTeacher#getNameTeacher()
	 */
//	@Override
	public String getNameTeacher() {
		return nameTeacher;
	}

	public float[] getNoteTeacher() {
		return noteTeacher;
	}

	public int getCountMedii() {
		return countMedii;
	}

	public float[] getRanks() {
		return ranks;
	}

//	public static float[] getTeacherRank() {
//		return teacherRank;
//	}

}
