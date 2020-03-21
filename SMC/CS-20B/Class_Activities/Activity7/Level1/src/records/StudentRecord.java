package records;

import students.Student;

public class StudentRecord {
	
	Student student;
	int grade;

	public StudentRecord(Student student, int grade) {
		this.student = student;
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public boolean equals(Object s) {
		if (this == s)
			return true;
		if (s == null)
			return false;
		if (s instanceof Student) {
			Student st = (Student) s;
			return st.equals(this.student);
		}
		if (s instanceof StudentRecord) {
			StudentRecord sr = (StudentRecord) s;
			if (student == null) {
				if (sr.student == null) {
					return true;
				}
			} else if (sr.student.equals(this.student)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		StudentRecord other = (StudentRecord) obj;
//		if (grade != other.grade)
//			return false;
//		if (student == null) {
//			if (other.student != null)
//				return false;
//		} else if (!student.equals(other.student))
//			return false;
//		return true;
//	}

	public String toString() {
		return this.student.getName() + " " + this.student.getSurname();
	}
}
