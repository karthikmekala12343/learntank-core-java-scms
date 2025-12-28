package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

	private final List<Student> students;

	public StudentService() {
		this.students = new ArrayList<>();
	}

	public void listStudents() {
		if (students.isEmpty()) {
			System.out.println("No students found");
			return;
		}

		System.out.println("List of students");
		for (Student student : students) {
			System.out.println("ID: " + student.getId() + " | Name: " + student.getDisplayName() + " | Active: "
					+ student.isActive());
		}

	}

	public void addStudent(Student student) {
		students.add(student);
		System.out
				.println("Student added successfully. ID: " + student.getId() + ", Name: " + student.getDisplayName());

	}

	public Student getStudentById(int id) throws EntityNotFoundException {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		throw new EntityNotFoundException("Student with ID " + id + " not found.");
	}

	public void deactivateStudent(int id) {
		try {
			Student student = getStudentById(id);
			student.setActive(false);
			System.out.println("Student deactivated successfully.");
		} catch (EntityNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public boolean studentExists(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Student viewStudent(int studentId) {
		System.out.println("\n--- View Student ID: " + studentId + " ---");
		boolean found = false;
		for (Student student : students) {
			if (student.getId() == studentId) {
				System.out.println("ID: " + student.getId() + " | Name: " + student.getDisplayName() + " | Active: "
						+ student.isActive());
				return student;
			}
		}
		if (!found) {
			System.out.println("No students found for this Id.");
		}
		return null;

	}
}
