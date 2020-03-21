package apps;

import java.time.LocalDate;

import management.Course;
import students.PhDStudent;
import students.Student;
import students.UndergraduateStudent;

public class StudentDriver {

	public static void main(String[] args) {
		// Student class is an abstract class!
//		LocalDate d = LocalDate.of(1995, 11, 3);
//		Student nash = new Student(12345, "Nashir", "Janmohamed", d);
//		System.out.println(nash);
		
		LocalDate d = LocalDate.of(1995, 11, 3);
		UndergraduateStudent nashir = new UndergraduateStudent(12345, "Nashir", "Janmohamed", d, "Computer Science");
		System.out.println(nashir);
		
		LocalDate d1 = LocalDate.of(1992, 9, 3);
		UndergraduateStudent joe = new UndergraduateStudent(90284, "Joe", "Kwon", d1, "Jazz Studies");
		System.out.println(joe);
		
		LocalDate d2 = LocalDate.of(1997, 4, 29);
		UndergraduateStudent david = new UndergraduateStudent(94201, "David", "Reynolds", d2);
		System.out.println(david);
		
		LocalDate d3 = LocalDate.of(1997, 3, 14);
		UndergraduateStudent mary = new UndergraduateStudent(34203, "Mary", "Smith", d3);
		mary.chooseMajor("Chemistry");
		System.out.println(mary);
		
		LocalDate d4 = LocalDate.of(1993, 2, 8);
		int phdDuration = 4;
		PhDStudent yoojin = new PhDStudent(48956, "Yoojin", "Kim", d4, phdDuration);
		System.out.println(yoojin);
		
		LocalDate d5 = LocalDate.of(1993, 2, 8);
		LocalDate enrollmentDate = LocalDate.of(2017, 9, 23);
		int phdDuration1 = 4;
		PhDStudent alex = new PhDStudent(48956, "Alex", "Keni", d5, enrollmentDate, phdDuration1);
		LocalDate alexDefence = LocalDate.of(2023, 5, 29);
		alex.setDefence(alexDefence);
		System.out.println(alex);
		
		Course dataStructures = new Course(5, "CS 20B");
		dataStructures.enroll(nashir);
		dataStructures.enroll(joe);
		dataStructures.enroll(david);
		dataStructures.enroll(mary);
		dataStructures.enroll(yoojin);
		if (!dataStructures.enroll(alex)) {
			System.out.println("class is full");
		}
		
		System.out.println(dataStructures);
		
		dataStructures.drop(david);
		
//		if (!dataStructures.drop(david)) {
//			System.out.println("david is not in the class anymore");
//		}
		
		System.out.println("Class average: " + dataStructures.calculateClassAverage());

		System.out.println(dataStructures);
	}

}
