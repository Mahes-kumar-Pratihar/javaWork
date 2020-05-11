import university.*;

public class ExampleApp {

	public static void main(String[] args) {
		
		String universityName = "Politecnico di Torino";
		
		University poli = new University(universityName);
		
		poli.setRector("Guido", "Saracco");
		
		System.out.println("Rector of " + poli.getName() + " : " + poli.getRector()); 
		//Rector of Politecnico di Torino : Guido Saracco
		
		int s1 = poli.enroll("Mario","Rossi");
		int s2 = poli.enroll("Giuseppe","Verdi");
		int s3 = poli.enroll("Dante","Alighieri");
		int s4 = poli.enroll("Francesco","Petrarca");
		int s5 = poli.enroll("Sandro","Botticelli");
		
		System.out.println("Enrolled students " + s1 + ", " + s2+ ", " + s3 + ", " + s4 + ", " + s5);
		System.out.println("s1 = " + poli.student(s1));
		System.out.println("s4 = " + poli.student(s4)); 
		
		//Enrolled students 10000, 10001, 10002, 10003, 10004
		//s1 = 10000 Mario Rossi
		//s4 = 10003 Francesco Petrarca
		
		
		int macro = poli.activate("Macro Economics", "Paul Krugman");
		int oop = poli.activate("Object Oriented Programming", "James Gosling");
		int math = poli.activate("Introduction to Analysis", "A.B");
	    int nanotech = poli.activate("Nanotechnology", "R.F");
	    int chm = poli.activate("Chemistry of Complex Polymers", "S.N");
	    int emb = poli.activate("Embedded Systems", "R.T");
		
		System.out.println("Activated courses: " + macro + ", " + oop + ", " + math + ", " + nanotech + ", " + chm + ", " + emb);
		//Activated courses: 10, 11, 12, 13, 14, 15
		
		//Enrolling
		poli.register(s1, macro);
		poli.register(s2, macro);
		poli.register(s4, macro);
		
		poli.register(s2, oop);
		poli.register(s5, oop);
		
		poli.register(s1, emb);
		poli.register(s5, emb);
		poli.register(s4, emb);
		poli.register(s2, emb);
		poli.register(s3, emb);
		
		poli.register(s3, chm);
		poli.register(s2, chm);
		
		poli.register(s1, math);
		poli.register(s2, math);
		poli.register(s5, math);
		
		poli.register(s2, nanotech);
		
		//Exams
		poli.exam(s1, macro, 95);
		poli.exam(s1, emb, 92);
		poli.exam(s1, math, 93);
		
		poli.exam(s2, nanotech, 100);
		poli.exam(s2, emb, 99);
		poli.exam(s2, math, 99);
		poli.exam(s2, oop, 97);
		poli.exam(s2, macro, 99);
		
		poli.exam(s3, chm, 68);
		
		poli.exam(s5, emb, 52);
		poli.exam(s5, math, 90);
		
		
		System.out.println(poli.studentAvg(s1));
		System.out.println(poli.studentAvg(s2));
		System.out.println(poli.studentAvg(s3));
		System.out.println(poli.studentAvg(s4));
		System.out.println(poli.studentAvg(s5));
		//Student 10000 : 93.33333333333333
		//Student 10001 : 98.8
		//Student 10002 : 68.0
		//Student 10003 hasn't taken any exams
		//Student 10004 : 71.0
		
		
		
		
		System.out.print(poli.courseAvg(macro));
		System.out.println(poli.courseAvg(oop));
		System.out.print(poli.courseAvg(chm));
		System.out.println(poli.courseAvg(nanotech));
		System.out.print(poli.courseAvg(emb));
		System.out.println(poli.courseAvg(math));
		
		//The average for the course Macro Economics is: 97.0
		//The average for the course Object Oriented Programming is: 97.0
		//The average for the course Chemistry of Complex Polymers is: 68.0
		//The average for the course Nanotechnology is: 100.0
		//The average for the course Embedded Systems is: 81.0
		//The average for the course Introduction to Analysis is: 94.0
		
		System.out.println(poli.listAttendees(macro));
		//10000 Mario Rossi
		//10001 Giuseppe Verdi
		//10003 Francesco Petrarca
		
		System.out.println(poli.listAttendees(emb));
		//10000 Mario Rossi
		//10004 Sandro Botticelli
		//10003 Francesco Petrarca
		//10001 Giuseppe Verdi
		//10002 Dante Alighieri
		
		System.out.println(poli.studyPlan(s2));
		//10,Macro Economics,Paul Krugman
		//11,Object Oriented Programming,James Gosling
		//15,Embedded Systems,R.T
		//14,Chemistry of Complex Polymers,S.N
		//12,Introduction to Analysis,A.B
		//13,Nanotechnology,R.F
		
		System.out.println(poli.studyPlan(s4));
		//10,Macro Economics,Paul Krugman
		//15,Embedded Systems,R.T
		System.out.println(poli.studentAvg(s2));
		System.out.println(poli.topThreeStudents());
		//10001 Giuseppe Verdi : 107.13333333333333
		//10000 Mario Rossi : 103.33333333333333
		//10004 Sandro Botticelli : 77.66666666666667
	}
}
