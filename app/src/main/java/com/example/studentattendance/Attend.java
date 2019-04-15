package com.example.studentattendance;

public class Attend {
    private int course_id;
    private int student_id;
    private int lecture_id;
    private int attend_attendance;
    private String attend_note;

    public Attend(int course_id, int student_id, int lecture_id, int attend_attendance) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.lecture_id = lecture_id;
        this.attend_attendance = attend_attendance;
    }

    public Attend(int course_id, int student_id, int lecture_id, int attend_attendance, String attend_note) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.lecture_id = lecture_id;
        this.attend_attendance = attend_attendance;
        this.attend_note = attend_note;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public int getAttend_attendance() {
        return attend_attendance;
    }

    public void setAttend_attendance(int attend_attendance) {
        this.attend_attendance = attend_attendance;
    }

    public String getAttend_note() {
        return attend_note;
    }

    public void setAttend_note(String attend_note) {
        this.attend_note = attend_note;
    }
}
