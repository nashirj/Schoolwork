package management;

import students.Student;

public interface CourseManagement {
	boolean enroll(Student st);
	boolean drop(Student st);
	double calculateClassAverage();
}
