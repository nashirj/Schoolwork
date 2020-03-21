package students;

import java.time.LocalDate;

public class PhDStudent extends Student {
	
	protected LocalDate defenceDate;
	protected LocalDate enrollmentDate;
	protected int phDdurationYears;

	/**
	 * Constructor for when enrollmentDate is not passed, set it to the current date.
	 * @param studentNumber
	 * @param name
	 * @param surname
	 * @param dateOfBirth
	 * @param phDdurationYears
	 */
	public PhDStudent(int studentNumber, String name, String surname, LocalDate dateOfBirth,
			int phDdurationYears) {
		super(studentNumber, name, surname, dateOfBirth);
		this.enrollmentDate = LocalDate.now();
		this.phDdurationYears = phDdurationYears;
	}
	
	/**
	 * Constructor for when all values are passed.
	 * @param studentNumber
	 * @param name
	 * @param surname
	 * @param dateOfBirth
	 * @param enrollmentDate
	 * @param phDdurationYears
	 */
	public PhDStudent(int studentNumber, String name, String surname, LocalDate dateOfBirth,
			LocalDate enrollmentDate, int phDdurationYears) {
		super(studentNumber, name, surname, dateOfBirth);
		this.enrollmentDate = enrollmentDate;
		this.phDdurationYears = phDdurationYears;
	}
	
	public boolean setDefence(LocalDate proposedDate) {
//		scheduleDefence which takes a proposed LocalDate for the defense and returns
//		true/false denoting whether scheduling is successful or not. The method will
//		return true if the proposed defense date is more than phDdurationYears years
//		later than the enrollment date. Otherwise it returns false. If the result is
//		true, the method sets the defense date for the student.
		long years = java.time.temporal.ChronoUnit.YEARS.between(this.enrollmentDate, proposedDate);
		if (years > phDdurationYears) {
			this.defenceDate = proposedDate;
			return true;
		}
		return false;
	}
	
	public String getDefenceDate() {
		if (defenceDate == null) {
			return "Not scheduled";
		}
		return defenceDate.toString();
	}
	
	public String toString() {
		return "PhD Student -> "
			 + "Name = " + name + ", "
			 + "Surname = " + surname + ", "
			 + "Date of Birth = " + dateOfBirth + ", "
			 + "Student ID = " + studentNumber + ", "
			 + "Enrollment Date = " + enrollmentDate + ", "
			 + "PhD Duration = " + phDdurationYears + ", "
			 + "Defence Date = " + getDefenceDate() + ".";
	}

}
