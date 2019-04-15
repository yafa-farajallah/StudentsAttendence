package com.example.studentattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    Button addStudents , addCourses , listStudents , listCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.databaseAdapter = new DatabaseAdapter(this);
        this.addCourses = findViewById(R.id.addCoursebtn);
        this.addStudents = findViewById(R.id.addStudentsbtn);
        this.listCourses = findViewById(R.id.listAllcoursesBtn);
        this.listStudents = findViewById(R.id.listAllStudentsBtn);
//                databaseAdapter.close();

        addCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCourseActivity.class);
                startActivity(intent);

            }
        });
        addStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(intent);

            }
        });
            listStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListStudentsActivity.class);
                startActivity(intent);

            }
        });
            listCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListCoursesActivity.class);
                startActivity(intent);

            }
        });

    }
}
