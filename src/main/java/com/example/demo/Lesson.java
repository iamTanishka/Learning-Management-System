package com.example.demo;

public class Lesson {
    private int lessonid;
    private int moduleid;
    private String tittle;
    private String discription;
    private String videoUrl;
    public Lesson(int lessonid, int moduleid, String tittle, String discription, String videoUrl){
        this.lessonid=lessonid;
        this.moduleid=moduleid;
        this.tittle=tittle;
        this.discription=discription;
        this.videoUrl=videoUrl;
    }

    public int getLessonid() {
        return lessonid;
    }

    public int getModuleid() {
        return moduleid;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDiscription() {
        return discription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setLessonid(int lessonid) {
        this.lessonid = lessonid;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
