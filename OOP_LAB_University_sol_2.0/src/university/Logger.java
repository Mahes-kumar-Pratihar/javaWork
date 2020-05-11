package university;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
    private final String logFile = "university_log.txt";
    private PrintWriter writer;
    private static Logger logger = null;
    
    private Logger() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }
    
    public static synchronized Logger getInstance(){
        if (logger == null) {
        	logger = new Logger();
        }
        return logger;
    }
    
    public void logEnrollStudent (int studentID, String name, String surname) {
        writer.println("New student enrolled: " + studentID + ", "
            + name + " " + surname);
    }
    public void logCourse(int courseCode, String name, String teacher) {
    	writer.println("New course activated: " + courseCode + ", "
                + name + " " + teacher);
    }
    public void logStudentSignedForCourse(int studentID, int courseCode) {
    	writer.println("Student " + studentID + " signed up for course "
                + courseCode);
    }
    public void logStudentTookAnExam(int studentID, int courseCode, int points) {
    	writer.println("Student " + studentID + " took an exam in course " 
                + courseCode + " and won " + points + " points.");
    }
}
