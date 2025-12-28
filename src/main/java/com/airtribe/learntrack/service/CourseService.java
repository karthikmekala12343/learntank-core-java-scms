package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

	private final List<Course> courses;

	public CourseService() {
		this.courses = new ArrayList<>();
	}

	public void addCourse(Course course) {
		courses.add(course);
		System.out.println("Course added successfully: " + course.getCourseName());
	}

	public Course getCourseById(int id) throws EntityNotFoundException {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		throw new EntityNotFoundException("Course with ID " + id + " not found.");
	}

	public void listCourses() {
		if (courses.isEmpty()) {
			System.out.println("No courses found.");
			return;
		}
		System.out.println("\n--- List of Courses ---");
		for (Course c : courses) {
			System.out.println("ID: " + c.getId() + " | Name: " + c.getCourseName() + " | Active: " + c.isActive());
		}
	}

	public void toggleCourseStatus(int id) {
		try {
			Course c = getCourseById(id);
			c.setActive(!c.isActive());
			System.out.println("Course status updated. Now Active: " + c.isActive());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean courseExists(int id) {
		return courses.stream().anyMatch(c -> c.getId() == id);
	}

}
