package com.example.demo;

public class Lesson {
    private int lessonId;
    private String lessonTitle;
    private String content;
    private String videoUrl;

    public Lesson(int lessonId, String lessonTitle, String content, String videoUrl) {
        this.lessonId = lessonId;
        this.lessonTitle = lessonTitle;
        this.content = content;
        this.videoUrl = videoUrl;
    }
    @Override
    public String toString() {
        return "    - Lesson: " + lessonTitle + " (Content: " + content + ")";
    }
}