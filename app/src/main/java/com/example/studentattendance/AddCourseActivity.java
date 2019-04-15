package com.example.studentattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddCourseActivity extends AppCompatActivity {

    EditText coursename , courseid;
    Button addBtn , listAllBtn;
    Courses course = new Courses();

    DatabaseAdapter databaseAdapter;
   // public  static ArrayList<Courses> c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        coursename = findViewById(R.id.coursename);
        courseid = findViewById(R.id.courseid);
        addBtn = findViewById(R.id.addbtn);
        listAllBtn = findViewById(R.id.listAllBtn);
        this.databaseAdapter = new DatabaseAdapter(this);


    addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = Integer.parseInt(courseid.getText().toString());
            String name = coursename.getText().toString();
            course.setCourse_id(id);
            course.setCourse_name(name);
            databaseAdapter.open();

            databaseAdapter.addCourses(course);
         //   c.add(course);
            databaseAdapter.close();
            coursename.setText("");
            courseid.setText("");

        }
    });
       listAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListCoursesActivity.class);
                startActivity(intent);
            }
        });
    }

}
