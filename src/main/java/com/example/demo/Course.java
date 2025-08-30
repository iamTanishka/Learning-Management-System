package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String title;
    private String description;
    private User instructor;
    private List<Lesson> lessons;
    private List<User> enrolledStudents;

    public Course(int courseId, String title, String description, User instructor) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructor = instructor; // <-- ADDED
        this.lessons = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public User getInstructor() {
        return instructor;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void enrollStudent(User student) {
        this.enrolledStudents.add(student);
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Instructor: " + instructor.getUserName()); // <-- MODIFIED: To show instructor
        System.out.println("Lessons:");
        if (lessons.isEmpty()) {
            System.out.println("    No lessons in this course yet.");
        } else {
            for (Lesson lesson : lessons) {
                System.out.println(lesson);
            }
        }
    }
}