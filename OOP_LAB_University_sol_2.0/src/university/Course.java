package university;

public class Course {
	
	private int num_stud = 0;
	private int code;
	private String title;
	private String teacher;
	private Student[] students;
	
	public Course(int code, String title, String teacher) {
		this.code = code;
		this.title = title;
		this.teacher = teacher;
		this.students = new Student[University.MAX_ATTENDEES];
	}
	
	public void enrollStudents(Student student) {
		students[num_stud++] = student;
	}
	
	public String listAtendees() {
		String attendees = "";
		for (int i=0; i<num_stud; i++) {
			attendees += students[i].toString() + "\n";
		}
		return attendees;
	}
	
	public String atendeesAvg() {
		double s = 0;
		int num_grades = 0;
		for (int i=0; i<num_stud; i++) {
			int grade = students[i].getGrades(this);
			if (grade != -1) {
				s += grade;
				num_grades += 1;
			}
		}
		if (num_grades >= 1) {
			return "The average for the course " + title + " is: " + s/num_grades + "\n";
		}
		return "No student has taken the exam in " + title;
	}
	
	@Override
	public String toString() {
		Integer course_id = code;
		return course_id + "," + title + "," + teacher;
	}

}
