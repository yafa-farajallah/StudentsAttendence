package com.example.studentattendance;

public class Lectures {
    private int course_id;
    private int lecture_id;
    private String lecture_date;

    public Lectures(int course_id, int lecture_id, String lecture_date) {
        this.course_id = course_id;
        this.lecture_id = lecture_id;
        this.lecture_date = lecture_date;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLecture_date() {
        return lecture_date;
    }

    public void setLecture_date(String lecture_date) {
        this.lecture_date = lecture_date;
    }
}
