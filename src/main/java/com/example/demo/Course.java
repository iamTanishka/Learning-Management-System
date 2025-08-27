package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int Courseid;
    private String title;
    private String description;
    private List<Lesson> lessons;
    public Course(int Courseid, String title, String description  ) {
        this.Courseid = Courseid;
        this.title = title;
        this.description = description;
        this.lessons = new ArrayList<>();
    }
    public int getcourseid(){
        return Courseid;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setCourseid(int courseid) {
        Courseid = courseid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
