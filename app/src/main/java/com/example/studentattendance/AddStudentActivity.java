package com.example.studentattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    EditText studentname , studentid;
    Button addBtn,listAllBtn;

    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        this.studentid =findViewById(R.id.studentid);
        this.studentname =findViewById(R.id.studentname);
        this.addBtn =findViewById(R.id.addbtn);
        this.listAllBtn =findViewById(R.id.listAllBtn);
        this.databaseAdapter = new DatabaseAdapter(this);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAdapter.open();
                Students student = new Students(Integer.parseInt(studentid.getText().toString()),
                        studentname.getText().toString());

                databaseAdapter.addStudent(student);

                studentid.setText("");
                studentname.setText("");
                databaseAdapter.close();
            }
        });

        listAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListStudentsActivity.class);
                startActivity(intent);

            }
        });
        //get the elements by id
        //        //create adapter object of the database
        //        //button listener
        //        //in the button listener make an object of student
        //        //set the values of the object from the elements(consider parsing)
        //        //in the button open the database, databaseAdapter.ADDSTUDENT(student), then close the database
        //        //validate the data(if null) , clear the elements after adding the object , consider input type
        //        //create a list and add the student to it(arrayABAPTER)
        //        //in the database adapter create getAllStudents
        //        //create another activity to view all the students(StudentListActivity)
        //        //in the xml file of the activity create a listView element
        //        //in the StudentListActivity create object of database adapter get the elements
        //        //in the StudentListActivity create ArrayAdapter
        //        //open the database
        //        //create a function getAllStudents in the database adapter(such as the getAllTasks) , create student_columns to use it here
        //        //in the student List activity crate a listView , and set its data from the database (students = database.getAllStudents)
        //        //arrayAdapter = new arrayAdapter (context  , ..... , )
        //        //link the adapter to the listView
        //        //button in the addStudentActivity to move you to the StudentListActivity(intent)
    }
}
