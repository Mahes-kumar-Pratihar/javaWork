package university;

public class Student {
	
	private int id;
	private String first;
	private String last;
	private Course[] courses;
	private int[] grades;
	private int course_num = 0;
	
	public Student(int id, String first, String last) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.courses = new Course[University.MAX_NUMBER_COURSES];
		this.grades = new int[University.MAX_NUMBER_COURSES];
	}
	
	public void addCourse(Course course) {
		courses[course_num] = course;
		grades[course_num++] = -1;
	}
	
	public void setGrades(Course course, int grade) {
		for (int i=0; i<course_num; i++) {
			if (courses[i] == course)
				grades[i] = grade;
		}
	}
	
	public int getGrades(Course course) {
		for (int i=0; i<course_num; i++) {
			if (courses[i] == course)
				return grades[i];
		}
		return  -1;
	}

	public String getAvg() {
		double s = 0;
		Integer student_id = id;
		int exams_taken = 0;
		for (int i=0; i<course_num; i++) {
			if (grades[i] != -1) {
					s += grades[i];
					exams_taken += 1;
			}
		}
		if (exams_taken >= 1) {
			return "Student " + student_id + " : " + s/exams_taken;
		} else {
			return "Student " + student_id + " hasn't taken any exams";
		}
	}
	
	public double getAvgGrade() {
		double s = 0;
		int exams_taken = 0;
		for (int i=0; i<course_num; i++) {
			if (grades[i] != -1) {
					s += grades[i];
					exams_taken += 1;
			}
		}
		if (exams_taken >= 1) {
			return s/exams_taken + ((double)exams_taken/course_num)* 10.0;
		}
		return 0.0;
	}
	
	public String studyPlan() {
		StringBuffer plan = new StringBuffer();
		for (int i=0; i<course_num; i++) {
			plan.append(courses[i]).append("\n");
		}
		return plan.toString();
	}
	
	@Override
	public String toString() {
		Integer student_id = id;
		return student_id + " " + first + " " + last;
	}
	
}
