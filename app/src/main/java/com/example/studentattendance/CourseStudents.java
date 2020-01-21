package com.example.studentattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class CourseStudents extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView studentsList;
    ArrayList<Students> students = new ArrayList<>();
    CourseStudentAdapter studentAdapter;
    int courseId,studentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_students);

        Intent intent=getIntent();
        courseId=intent.getIntExtra("courseid",-1);
        studentsList =findViewById(R.id.coursestudentslist);

        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        students = databaseAdapter.getCourseStudents(courseId);

        studentAdapter = new CourseStudentAdapter(this , students);
        this.studentsList.setAdapter(studentAdapter);
        databaseAdapter.close();

        studentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Students student =students.get(position);

                studentid =student.getStudent_id();
                databaseAdapter.open();




                databaseAdapter.close();


            }
        });
    }
}
