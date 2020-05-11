package university;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */
public class University {

	public static final int INITIAL_COURSE_CODE = 10;
	public static final  int INITIAL_STUDENT_ID = 10000;
	public static final int MAX_COURSE_NUM = 50;
	public static final int MAX_STUDENT_NUM = 1000;
	
	public final static int MAX_NUMBER_COURSES = 25;
	public final static int MAX_ATTENDEES = 100;
	
	private int course_index = INITIAL_COURSE_CODE;
	private int student_index = INITIAL_STUDENT_ID;
	
	
	private String name;
	private String rector;
	
	private Student[] students;
	private Course[] courses;
	
	/**
	 * Constructor
	 * @param name name of the university
	 */
	public University(String name){
		this.name = name;
		this.rector = "<none>";
		
		students = new Student[MAX_STUDENT_NUM];
		courses = new Course[MAX_COURSE_NUM];
	}
	
	/**
	 * Getter for the name of the university
	 * @return name of university
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.rector = first + " " + last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return
	 */
	public String getRector(){
		return rector;
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first first name of the student
	 * @param last last name of the student
	 * @return
	 */
	public int enroll(String first, String last){
		Student s = new Student(student_index, first, last);
		students[student_index-INITIAL_STUDENT_ID] = s;
		Logger.getInstance().logEnrollStudent(student_index, first, last);
		return student_index++;
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param id the id of the student
	 * @return information about the student
	 */
	public String student(int id){
		return students[id-INITIAL_STUDENT_ID].toString();
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param title title of the course
	 * @param teacher name of the teacher
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		Course c = new Course(course_index, title, teacher);
		courses[course_index-INITIAL_COURSE_CODE] = c;
		Logger.getInstance().logCourse(course_index, title, teacher);
		return course_index++;
	}
	
	/**
	 * Retrieve the information for a given course
	 * 
	 * @param code unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		return courses[code-INITIAL_COURSE_CODE].toString();
	}
	
	/**
	 * Register a student to attend a course
	 * @param studentID id of the student
	 * @param courseCode id of the course
	 */
	public void register(int studentID, int courseCode){
		Student s = students[studentID-INITIAL_STUDENT_ID];
		Course c = courses[courseCode-INITIAL_COURSE_CODE];
		Logger.getInstance().logStudentSignedForCourse(studentID, courseCode);
		s.addCourse(c);
		c.enrollStudents(s);
	}
	/**
	 * Register score for a student that took an exam
	 * 
	 * @param studentID unique id of the student
	 * @param courseCode unique id of the course
     * @param point number of points the student won
	 */
	public void exam(int studentID, int courseCode, int points) {
		Student s = students[studentID-INITIAL_STUDENT_ID];
		s.setGrades(courses[courseCode-INITIAL_COURSE_CODE], points);
		Logger.getInstance().logStudentTookAnExam(studentID, courseCode, points);
	}
	/**
	 * Retrieve average number of points for a student
	 * 
	 * @param studentID unique id of the student
	 * @return string containing the id of the student and averaged points
	 */
	public String studentAvg(int studentID) {
		return students[studentID-INITIAL_STUDENT_ID].getAvg();
	}
	
	/**
	 * Retrieve average number of points for a course
	 * 
	 * @param courseID unique id of the course
	 * @return string containing the id of the course and averaged points
	 */
	public String courseAvg(int courseID) {
		return courses[courseID-INITIAL_COURSE_CODE].atendeesAvg();
	}
	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode unique id of the course
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		return courses[courseCode-INITIAL_COURSE_CODE].listAtendees();
	}
	
	/**
	 * Retrieve a list of top 3 students
	 * 
	 * @return list of students separated by "\n"
	 */
	public String topThreeStudents() {
		int n_students = student_index-INITIAL_STUDENT_ID;
		Student ordered_students[] = new Student[n_students];
		for(int i=0; i<n_students; i++) {
			Student s = students[i];
			int j=0;
			//find the position where to insert a new student based on 
			//his average score
			while (j<i && s.getAvgGrade() >= ordered_students[j].getAvgGrade()) {
				j++;
			}
			
			if (j==i) {
				//if it at the end of the list just append it
				ordered_students[j] = s;
			} else {
				//otherwise shifting is neccessary to insert the new 
				//one in the middle
				for (int k=i-1; k>=j; k--) {
					ordered_students[k+1] = ordered_students[k];
				}
				ordered_students[j] = s;
			}
		}
		StringBuffer top3 = new StringBuffer();
		if (n_students >= 3) {
			for (int i=n_students-1; i>=n_students-3; i--) {
				top3.append(ordered_students[i]).append(" : ")
				.append(ordered_students[i].getAvgGrade()).append("\n");
			}
			return top3.toString();
		} 
		return "Less than 3 students enrolled at the university";
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param studentID id of the student
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		return students[studentID-INITIAL_STUDENT_ID].studyPlan();
	}
}
