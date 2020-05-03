package student;

import java.util.Arrays;

public class StudentList {
	private Student[] students;
	private int count;
	
	public StudentList() {
		students = new Student[5];
		count = -1;
	}
	
	public void Add(Student st) {
		if (count == students.length - 1) {
			students = Arrays.copyOf(students, students.length*2);
		}
		students[++count] = st;
	}

	public Student get(int i) {
		if (i < size())
		return students[i];
		else return null;
	}

	public int size() {
		return count+1;
	}
	
	public StudentList GetStudentsByFaculty(String faculty) {
		StudentList studentsByFaculty = new StudentList();
		for (int i = 0; i < size(); i++) {
			if (students[i].getFaculty().equals(faculty)) {
				studentsByFaculty.Add(students[i]);
			}
		}
		return studentsByFaculty;
	}
	
	public StudentList GetStudentsByFacultyAndYear(String faculty, int year) {
		StudentList studentsByFacultyAndYear = new StudentList();
		for (int i = 0; i < size(); i++) {
			if ((students[i].getFaculty().equals(faculty)) && (students[i].getYear() == year)) {
				studentsByFacultyAndYear.Add(students[i]);
			}
		}
		return studentsByFacultyAndYear;
	}
	
	public StudentList GetStudentsByDateOfBirth (int date) {
		StudentList studentsByDate = new StudentList();
		for (int i = 0; i < size(); i++) {
			if (students[i].getDateOfBirth() > date) {
				studentsByDate.Add(students[i]);
			}
		}
		return studentsByDate;
	}
	
	public StudentList GetStudentsByGroup (int group) {
		StudentList studentsByGroup = new StudentList();
		for (int i = 0; i < size(); i++) {
			if (students[i].getGroup() == group) {
				studentsByGroup.Add(students[i]);
			}
		}
		return studentsByGroup;
	}
	
	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.println(students[i]);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + Arrays.hashCode(students);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentList other = (StudentList) obj;
		if (count != other.count)
			return false;
		if (!Arrays.equals(students, other.students))
			return false;
		return true;
	}
	
}
