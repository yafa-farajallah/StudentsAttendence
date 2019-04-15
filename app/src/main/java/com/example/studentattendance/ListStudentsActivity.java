package com.example.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListStudentsActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView studentlist;
    ArrayList<Students> students = new ArrayList<>();
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        this.studentlist = findViewById(R.id.studentslist);
        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        students = databaseAdapter.getAllStudents();

        studentAdapter = new StudentAdapter(this , students);
        this.studentlist.setAdapter(studentAdapter);
        databaseAdapter.close();
    }
}
