package students;

import java.time.LocalDate;

import students.Student;

public class UndergraduateStudent extends Student {
	
	protected String major;

	public UndergraduateStudent(int studentNumber, String name, String surname, LocalDate dateOfBirth) {
		this(studentNumber, name, surname, dateOfBirth, "Undeclared");
	}
	
	public UndergraduateStudent(int studentNumber, String name, String surname, LocalDate dateOfBirth, String major) {
		super(studentNumber, name, surname, dateOfBirth);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}
	
	public void chooseMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		return "Undergraduate Student -> "
				 + "Name = " + name + ", "
				 + "Surname = " + surname + ", "
				 + "Date of Birth = " + dateOfBirth + ", "
				 + "Student ID = " + studentNumber + ", "
				 + "Major = " + major + ".";
	}

}
