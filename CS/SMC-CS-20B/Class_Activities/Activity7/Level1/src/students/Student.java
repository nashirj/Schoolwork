package students;

import java.time.LocalDate;

import records.StudentRecord;

public abstract class Student {
	
	protected final int studentNumber;
	protected String name;
	protected String surname;
	protected final LocalDate dateOfBirth;

	public Student(int studentNumber, String name, String surname, LocalDate dateOfBirth) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String toString() {
		return "Student -> Name = " + name + ", "
			 + "Surname = " + surname + ", "
			 + "Date of Birth = " + dateOfBirth + ", "
			 + "Student ID = " + studentNumber + ".";
	}
	
//	public boolean equals(Student s) {
//		return s.studentNumber == this.studentNumber;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/**
		 * TODO: this is disgusting make it better
		 */
		if (obj instanceof StudentRecord) {
			StudentRecord sr = (StudentRecord) obj;
			if (this != null) {
				if (sr.getStudent() == null) {
					return false;
				}
				if (sr.getStudent().equals(this)) {
					return true;
				}
			}
		}
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNumber != other.studentNumber)
			return false;
		return true;
	}
	
	
}
