package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Platform {
    private List<User> users;
    private List<Course> courses;

    public Platform() {
        this.users = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User " + user.getUserName() + " registered successfully as a " + user.getRole() + ".");
    }

    public void createCourse(int courseId, String title, String description, User instructor) {
        if (instructor.getRole() == User.Role.Instructor) {
            Course newCourse = new Course(courseId, title, description, instructor);
            courses.add(newCourse);
            System.out.println("Course '" + title + "' created successfully!");
        } else {
            System.out.println("Error: Only an Instructor can create courses.");
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course findCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void enrollStudent(User student, Course course) {
        if (student.getRole() == User.Role.Learner) {
            course.enrollStudent(student);
            System.out.println("\n✅ Success! " + student.getUserName() + " has been enrolled in '" + course.getTitle() + "'.");
        } else {
            System.out.println("Error: Only a Learner can enroll in courses.");
        }
    }

    public void displayAllCourses() {
        System.out.println("\n📚 Available Courses on the Platform 📚");
        if (courses.isEmpty()) {
            System.out.println("No courses are available at the moment. An instructor must create one first.");
            return;
        }
        for (Course course : courses) {
            course.displayDetails();
        }
    }

    public void displayCoursesByInstructor(User instructor) {
        System.out.println("\n📖 Courses Created by You (" + instructor.getUserName() + ") 📖");
        boolean foundCourses = false;
        for (Course course : courses) {
            if (course.getInstructor() == instructor) {
                course.displayDetails();
                foundCourses = true;
            }
        }
        if (!foundCourses) {
            System.out.println("You have not created any courses yet.");
        }
    }

    public static void main(String args[]) {
        Platform platform = new Platform();
        Scanner sc = new Scanner(System.in);

        System.out.println("🎓 Welcome to the Online Learning Platform! 🎓");
        System.out.println("First, let's create your account.");

        System.out.print("Enter Name: ");
        String userName = sc.nextLine();
        System.out.print("Enter Email: ");
        String userEmail = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Role (Type 'Instructor' or 'Learner'): ");
        String choice = sc.nextLine();

        User.Role role = (choice.equalsIgnoreCase("Instructor")) ? User.Role.Instructor : User.Role.Learner;

        User newUser = new User(userName, userEmail, password, role);
        platform.registerUser(newUser);

        if (newUser.getRole() == User.Role.Instructor) {
            while (true) {
                System.out.println("\n--- Instructor Menu ---");
                System.out.println("1. Create a New Course");
                System.out.println("2. View My Created Courses");
                System.out.println("3. Exit");
                System.out.print("Please enter your choice: ");

                int menuChoice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline

                if (menuChoice == 1) {
                    System.out.println("\n=== Create a New Course ===");
                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Course Description: ");
                    String description = sc.nextLine();

                    platform.createCourse(courseId, title, description, newUser);

                    Course createdCourse = platform.findCourseById(courseId);
                    if (createdCourse != null) {
                        System.out.println("\nNow, let's add a lesson to '" + createdCourse.getTitle() + "'.");
                        System.out.print("Enter Lesson ID: ");
                        int lessonId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Lesson Title: ");
                        String lessonTitle = sc.nextLine();

                        System.out.print("Enter Lesson Content: ");
                        String lessonContent = sc.nextLine();

                        System.out.print("Enter Lesson Video URL: ");
                        String videoUrl = sc.nextLine();

                        Lesson newLesson = new Lesson(lessonId, lessonTitle, lessonContent, videoUrl);
                        createdCourse.addLesson(newLesson);

                        System.out.println("✅ Lesson added successfully to course: " + createdCourse.getTitle());
                    }
                } else if (menuChoice == 2) {
                    platform.displayCoursesByInstructor(newUser);
                } else if (menuChoice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            // --- LEARNER'S WORKFLOW ---
            System.out.println("\nHello Learner " + newUser.getUserName() + "! Here are the courses you can enroll in.");

            platform.displayAllCourses();

            if (!platform.getCourses().isEmpty()) {
                System.out.print("\nEnter the ID of the course you wish to enroll in: ");
                int courseIdToEnroll = sc.nextInt();
                sc.nextLine();

                Course courseToEnroll = platform.findCourseById(courseIdToEnroll);

                if (courseToEnroll != null) {
                    platform.enrollStudent(newUser, courseToEnroll);
                } else {
                    System.out.println(" Error: No course found with ID " + courseIdToEnroll + ".");
                }
            }
        }

        System.out.println("\nThank you for using the platform!");
        sc.close();
    }
}