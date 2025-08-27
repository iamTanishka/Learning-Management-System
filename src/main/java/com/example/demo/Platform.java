package com.example.demo;

import jakarta.servlet.ServletOutputStream;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Platform {
    private List<User>users;
    private List<Course>courses;
    public Platform(){
        this.users=new ArrayList<>();
        this.courses=new ArrayList<>();
    }
    public void registerUser(User user){
        users.add(user);
    }
    public void createCourse(int Courseid, String title, String description, User Instructor){
        if(Instructor.getRole()== User.Role.Instructor){
            courses.add(new Course(Courseid, title, description));
        }
        else{
            System.out.println("Only instructor can create courses");
        }
    }
    public List<Course> getCourse(){
        return courses;
    }
    public void enrollStudent(User student, Course course){
        if(student.getRole()== User.Role.Learner)
            System.out.println(student.getUserName()+"enrolled in"+course.getTitle());
    }
    public static void main(String args[]){
        Platform ob=new Platform();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Name:");
        String UserName=sc.nextLine();
        System.out.println("Enter Email");
        String UserEmail=sc.nextLine();
        System.out.println("Enter password");
        String Password=sc.nextLine();
        System.out.println("Enter Role(Instructor for Instructor, Learner  for Learner)");
        String choice=sc.nextLine();
        User.Role role=(choice.equalsIgnoreCase("Instructor"))? User.Role.Instructor:User.Role.Learner;

        User newUser=new User(UserName,UserEmail,Password,role);
        ob.registerUser(newUser);
    }
}
