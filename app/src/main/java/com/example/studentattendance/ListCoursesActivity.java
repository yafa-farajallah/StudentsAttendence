package com.example.studentattendance;

import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListCoursesActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView coursesList;
    ArrayList<Courses> courses = new ArrayList<>();
    coursesAdapter coursesAdapter;
    int courseid;
    int course_pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_courses);


        this.coursesList = findViewById(R.id.coursesList);
        registerForContextMenu(coursesList);
        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        courses = databaseAdapter.getAllCourses();

        coursesAdapter = new coursesAdapter(this, courses);
        this.coursesList.setAdapter(coursesAdapter);
        databaseAdapter.close();

        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2 = new Intent(getApplicationContext(), CourseStudents.class);
                intent2.putExtra("courseid",courseid);

                startActivity(intent2);
            }
        });

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info=  (AdapterView.AdapterContextMenuInfo)menuInfo;
        if(v.getId()==R.id.coursesList)
            getMenuInflater().inflate(R.menu.courses_menue,menu);
        courseid =courses.get(info.position).getCourse_id();



    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.item1:{
                Intent intent = new Intent(getApplicationContext(), AddStdToCourse.class);
                intent.putExtra("courseid",courseid);

                startActivity(intent);

                break;}
            case R.id.item2:
                Intent intent = new Intent(getApplicationContext(), UpdateCourse.class);
                intent.putExtra("oldid",courseid);
                startActivity(intent);
                break;
            case R.id.item3:
                courses.remove(course_pos);
                databaseAdapter.open();
                databaseAdapter.deleteCourse(courseid);
                databaseAdapter.close();
                coursesAdapter.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }

}
