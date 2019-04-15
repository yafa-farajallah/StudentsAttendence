package com.example.studentattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.studentattendance.SqLiteHelper.COURSE_ID;
import static com.example.studentattendance.SqLiteHelper.STUDENT_ID;

public class DatabaseAdapter {
    SQLiteDatabase database;
    SqLiteHelper sqlHelper;
    //all columns
    String[] StudentsColumns = {SqLiteHelper.STUDENT_ID, SqLiteHelper.STUDENT_NAME};
    String [] CoursesColumns = {COURSE_ID ,SqLiteHelper.COURSE_NAME };
    String [] EnrollmentColumns = {COURSE_ID, SqLiteHelper.STUDENT_ID};
    String [] LectureColumns = {COURSE_ID ,SqLiteHelper.LECTURE_ID,SqLiteHelper.LECTURE_DATE};
    String [] AttendColumns = {SqLiteHelper.STUDENT_ID, COURSE_ID ,SqLiteHelper.LECTURE_ID,
            SqLiteHelper.ATTEND_NOTE ,SqLiteHelper.ATTEND_ATTENDANCE};

    public DatabaseAdapter(Context context){
        this.sqlHelper = new SqLiteHelper(context);
    }

    public void open(){
        this.database = this.sqlHelper.getWritableDatabase();
    }

    public void close(){
        this.database.close();
    }

    public void addStudent(Students student){
        ContentValues values = new ContentValues();

        values.put(SqLiteHelper.STUDENT_NAME, student.getStudent_name());
        values.put(SqLiteHelper.STUDENT_ID, student.getStudent_id());

        this.database.insert(SqLiteHelper.STUDENT_TABLE, null, values);
    }

    public ArrayList<Students> getAllStudents(){
        Cursor cursor = this.database.query(SqLiteHelper.STUDENT_TABLE, StudentsColumns, null, null,
                null, null, null);
        ArrayList<Students> students = new ArrayList<Students>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);

            Students student = new Students(Integer.parseInt(id), name);

            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    public ArrayList<Students> getStudentsNotInTheCourse (int courseId){

         Cursor cursor = this.database.query(SqLiteHelper.STUDENT_TABLE, StudentsColumns,STUDENT_ID+ "NOT IN ("+
                 this.database.query(SqLiteHelper.ENROLLMENT_TABLE, new String []{STUDENT_ID},COURSE_ID+ "= " + courseId , null,
                         null, null, null)+") ", null,
                null, null, null);

        ArrayList<Students> students = new ArrayList<Students>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);

            Students student = new Students(Integer.parseInt(id), name);

            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    public void addCourses(Courses course){
        ContentValues values = new ContentValues();

        values.put(COURSE_ID, course.getCourse_id());
        values.put(SqLiteHelper.COURSE_NAME, course.getCourse_name());

        this.database.insert(SqLiteHelper.COURSE_TABLE, null, values);
    }

    public ArrayList<Courses> getAllCourses(){
        Cursor cursor = this.database.query(SqLiteHelper.COURSE_TABLE,CoursesColumns, null, null,
                null, null, null);
        ArrayList<Courses> courses = new ArrayList<Courses>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);

            Courses course = new Courses(Integer.parseInt(id), name);

            courses.add(course);
            cursor.moveToNext();
        }

        cursor.close();
        return courses;
    }

    public void addEnrollment(Enrollment enrolment){
        ContentValues values = new ContentValues();

        values.put(SqLiteHelper.COURSE_ID, enrolment.getCourse_id());
        values.put(SqLiteHelper.STUDENT_ID, enrolment.getStudent_id());

        this.database.insert(SqLiteHelper.ENROLLMENT_TABLE, null, values);
    }



}
