package management;

import students.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import records.StudentRecord;

public class Course implements CourseManagement {

	// TODO: consider parameterizing the grade!
	// can't with current implementation because of the calculateAverage method

	protected ArrayList<StudentRecord> studentRecords;
	protected Queue<StudentRecord> waitList;
	protected int classCapacity;
	protected int defaultGrade = 100;
	protected String courseName;
	
	public Course(int classCapacity, String courseName) {
		studentRecords = new ArrayList<StudentRecord>();
		waitList = new LinkedList<StudentRecord>();
		this.classCapacity = classCapacity;
		this.courseName = courseName;
	}
	
	@Override
	public boolean enroll(Student st) {
		if (isFull()) {
			waitList.add(new StudentRecord(st, defaultGrade));
			return false;
		}
		studentRecords.add(new StudentRecord(st, defaultGrade));
		return true;
	}

	@Override
	public boolean drop(Student st) {
		if (!studentRecords.contains(st)) {
			return false;
		}
		studentRecords.remove(st);
		if (!waitList.isEmpty()) {
			studentRecords.add(waitList.poll());
		}
		return true;
	}

	@Override
	public double calculateClassAverage() {
		int numStudents = studentRecords.size();
		if (numStudents == 0) {
			return 0;
		}
		long total = 0;
		for (StudentRecord sr : studentRecords) {
			total += sr.getGrade();
		}
		return (total * 1.0) / numStudents;
	}
	
	public boolean isFull() {
		return studentRecords.size() == classCapacity;
	}
	
	public String toString() {
		if (studentRecords.size() == 0) {
			return "There are no students currently enrolled in " + courseName;
		}
		StringBuilder s = new StringBuilder(courseName + "\n\tEnrolled Students: [");
		for (int i = 0; i < studentRecords.size() - 1; i++) {
			s.append(studentRecords.get(i));
			s.append(", ");
		}
		s.append(studentRecords.get(studentRecords.size() - 1));
		s.append("]");
		if (!waitList.isEmpty()) {
			s.append("\n\tStudents on the Waitlist: [");
			Iterator<StudentRecord> iterator = waitList.iterator();
			while (iterator.hasNext()) {
				s.append(iterator.next());
				if (iterator.hasNext())
					s.append(", ");
			}
			s.append("]");
		}
		
		return s.toString();
	}

}
