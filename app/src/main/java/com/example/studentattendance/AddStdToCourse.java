package com.example.studentattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AddStdToCourse extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView studentsList;
    ArrayList<Students> students = new ArrayList<>();
    StudentAdapter studentAdapter;
    int courseId,studentid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
         courseId=intent.getIntExtra("courseid",-1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_std_to_course);
        studentsList =findViewById(R.id.studentslistTobeAdded);

        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        students = databaseAdapter.getStudentsNotInTheCourse(courseId);

        studentAdapter = new StudentAdapter(this , students);
        this.studentsList.setAdapter(studentAdapter);
        databaseAdapter.close();

        studentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Students student =students.get(position);

                studentid =student.getStudent_id();
                databaseAdapter.open();
                Enrollment enrollment = new Enrollment( courseId,studentid);

                databaseAdapter.addEnrollment(enrollment);

                databaseAdapter.close();
                students.remove(position);
                studentAdapter.notifyDataSetChanged();

            }
        });

    }
}
