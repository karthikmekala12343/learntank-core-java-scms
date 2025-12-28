package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

public class Main {

	private static final StudentService studentService = new StudentService();
	private static final CourseService courseService = new CourseService();
	private static final EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

	public static void main(String[] args) {
		System.out.println("Welcome to LearnTrack - Student & Course Management System");

		boolean isRunning = Boolean.TRUE;
		while (isRunning) {

			displayMenus();

			int choice = InputValidator.getIntInput("Enter choice :");

			switch (choice) {
			case 1:
				studentMenu();
				break;
			case 2:
				courseMenu();
				break;
			case 3:
				enrollmentMenu();
				break;
			case 4:
				isRunning = Boolean.FALSE;
				System.out.println("Exiting LearnTrack.");
				break;

			default:
				System.out.println("Invalid Choice. Please try again.");
			}
		}

	}

	private static void courseMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- Course Menu ---");
			System.out.println("1. Add Course");
			System.out.println("2. View All Courses");
			System.out.println("3. Activate/Deactivate Course");
			System.out.println("4. Back to Main Menu");

			int choice = InputValidator.getIntInput("Enter choice: ");

			switch (choice) {
			case 1:
				String courseName = InputValidator.getStringInput("Enter Course Name: ");
				String description = InputValidator.getStringInput("Enter Description: ");
				int duration = InputValidator.getIntInput("Enter Duration (weeks): ");
				courseService.addCourse(new Course(courseName, description, duration));
				break;
			case 2:
				courseService.listCourses();
				break;
			case 3:
				int courseId = InputValidator.getIntInput("Enter Course ID to toggle status: ");
				courseService.toggleCourseStatus(courseId);
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private static void studentMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- Student Menu ---");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. View Student Enrollments");
			System.out.println("4. Deactivate Student");
			System.out.println("5. Back to Main Menu");

			int choice = InputValidator.getIntInput("Enter choice: ");

			switch (choice) {
			case 1:
				String firstName = InputValidator.getStringInput("Enter First Name: ");
				String lastName = InputValidator.getStringInput("Enter Last Name: ");
				String batch = InputValidator.getStringInput("Enter Batch Name: ");
				// Constructor overloading
				Student student = new Student(firstName, lastName, batch);
				studentService.addStudent(student);
				break;
			case 2:
				studentService.listStudents();
				break;
			case 3:
				int viewStudentId = InputValidator.getIntInput("Enter Student ID to view: ");
				studentService.viewStudent(viewStudentId);
				break;	
			case 4:
				int studentId = InputValidator.getIntInput("Enter Student ID to deactivate: ");
				studentService.deactivateStudent(studentId);
				break;
			case 5:
				back = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}

	}

	private static void enrollmentMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("\n--- Enrollment Menu ---");
			System.out.println("1. Enroll Student in Course");
			System.out.println("2. View Student Enrollments");
			System.out.println("3. Update Enrollment Status");
			System.out.println("4. Back to Main Menu");

			int choice = InputValidator.getIntInput("Enter choice: ");

			switch (choice) {
			case 1:
				int studentId = InputValidator.getIntInput("Enter Student ID: ");
				int courseId = InputValidator.getIntInput("Enter Course ID: ");
				enrollmentService.enrollStudent(studentId, courseId);
				break;
			case 2:
				int viewStudentId = InputValidator.getIntInput("Enter Student ID: ");
				enrollmentService.listEnrollmentsForStudent(viewStudentId);
				break;
			case 3:
				int enrollmentId = InputValidator.getIntInput("Enter Enrollment ID: ");
				System.out.println("Available Statuses: ACTIVE, COMPLETED, CANCELLED");
				String status = InputValidator.getStringInput("Enter new Status: ");
				enrollmentService.updateEnrollmentStatus(enrollmentId, status.toUpperCase());
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private static void displayMenus() {
		System.out.println("\n=== MAIN MENU ===");
		System.out.println("1. Student Management");
		System.out.println("2. Course Management");
		System.out.println("3. Enrollment Management");
		System.out.println("4. Exit");

	}
}
