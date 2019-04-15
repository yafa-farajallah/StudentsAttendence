package com.example.studentattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {

    ArrayList<Students> students;
    Context context;

    public StudentAdapter(Context context, ArrayList<Students> students) {
        super(context ,0 ,students);
        this.students = students;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_item_list, parent,
                    false);
        }

        TextView name =convertView.findViewById(R.id.student_item_name);
        TextView id = convertView.findViewById(R.id.student_item_id);

        Students student = (Students) getItem(position);

        name.setText(""+student.getStudent_name());
        id.setText(""+student.getStudent_id());

        return convertView;
    }
}
