package com.example.studentattendance;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class coursesAdapter extends ArrayAdapter<Courses> {
    ArrayList<Courses> courses;
    public coursesAdapter(Context context, ArrayList<Courses> courses) {
        super(context ,0 ,courses);
        this.courses = courses;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Courses course = courses.get(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.courses_list , parent , false);
        }

        TextView coursename =convertView.findViewById(R.id.coursename);
        TextView courseid = convertView.findViewById(R.id.courseid);

//        coursename.setText("@string/course_name "+course.getCourse_name());
        coursename.setText(""+course.getCourse_name());
//        courseid.setText("@string/course_id "+course.getCourse_id());
        courseid.setText(""+course.getCourse_id());


        return convertView;


    }
}
