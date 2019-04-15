package com.example.studentattendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StudentAttendance.db";
    public static final int VERSION = 2;
    //TABLES
    public static final String COURSE_TABLE = "courses";
    public static final String STUDENT_TABLE = "students";
    public static final String ENROLLMENT_TABLE = "enrollment";
    public static final String LECTURE_TABLE = "lectures";
    public static final String ATTEND_TABLE = "attend";

    //ATTRIBUTES
    public static final String COURSE_ID = "course_id";
    public static final String COURSE_NAME = "course_name";
    public static final String STUDENT_ID = "student_id";
    public static final String STUDENT_NAME = "student_name";
    public static final String LECTURE_ID = "lecture_id";
    public static final String LECTURE_DATE = "lecture_date";
    public static final String ATTEND_NOTE = "attend_note";
    public static final String ATTEND_ATTENDANCE = "attend_attendance";


    public SqLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE "  + COURSE_TABLE + "("
                 + COURSE_ID + " integer primary key ,"
                 + COURSE_NAME + " text not null )"
    );

    db.execSQL("CREATE TABLE "  + STUDENT_TABLE + "("
                 + STUDENT_ID + " integer primary key,"
                 + STUDENT_NAME + " text not null )"
    );

    db.execSQL("CREATE TABLE "  + ENROLLMENT_TABLE + "("
                     + COURSE_ID + " integer ,"
                     + STUDENT_ID + " integer  ,PRIMARY KEY(" + COURSE_ID + " , " + STUDENT_ID +"))"
        );
    db.execSQL("CREATE TABLE "  + LECTURE_TABLE+ "("
                     + COURSE_ID + " integer ,"
                     + LECTURE_ID + " integer  ,"
                     + LECTURE_DATE +" date ,PRIMARY KEY(" + COURSE_ID + " , " + LECTURE_ID +"))"
        );
    db.execSQL("CREATE TABLE " + ATTEND_TABLE + "("
            + STUDENT_ID + " integer ,"
            + COURSE_ID + " integer , "
            + LECTURE_ID + " integer , "
            +ATTEND_NOTE + " text ,"
            + ATTEND_ATTENDANCE +" integer ," +
            "PRIMARY KEY (" +COURSE_ID + " , " + STUDENT_ID + " , " + LECTURE_ID + "))"
    );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ATTEND_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LECTURE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ENROLLMENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        this.onCreate(db);
    }
}
