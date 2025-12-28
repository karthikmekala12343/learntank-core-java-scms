package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentService {

	private final List<Enrollment> enrollments;
	private final StudentService studentService;
	private final CourseService courseService;

	// constructor Injection
	public EnrollmentService(StudentService studentService, CourseService courseService) {
		this.enrollments = new ArrayList<>();
		this.studentService = studentService;
		this.courseService = courseService;
	}

	public void enrollStudent(int studentId, int courseId) {
		try {
			// Validate 
			studentService.getStudentById(studentId);
			courseService.getCourseById(courseId);

			// Check duplicate enrollment (simplified logic)
			for (Enrollment e : enrollments) {
				if (e.getStudentId() == studentId && e.getCourseId() == courseId && e.getStatus().equals("ACTIVE")) {
					System.out.println("Student is already actively enrolled in this course.");
					return;
				}
			}

			Enrollment enrollment = new Enrollment(studentId, courseId);
			enrollments.add(enrollment);
			System.out.println("Enrollment successful!");

		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			System.out.println("Enrollment failed: " + e.getMessage());
		}
	}

	public void listEnrollmentsForStudent(int studentId) {
		System.out.println("\n--- Enrollments for Student ID: " + studentId + " ---");
		boolean found = false;
		for (Enrollment e : enrollments) {
			if (e.getStudentId() == studentId) {
				System.out.println(e);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No enrollments found for this student.");
		}
	}

	public void updateEnrollmentStatus(int enrollmentId, String status) {
		for (Enrollment e : enrollments) {
			if (e.getId() == enrollmentId) {
				e.setStatus(status);
				System.out.println("Enrollment status updated to: " + status);
				return;
			}
		}
		System.out.println("Enrollment ID not found.");
	}
}
