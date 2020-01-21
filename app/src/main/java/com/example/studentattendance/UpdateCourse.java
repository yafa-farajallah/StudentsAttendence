package com.example.studentattendance;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCourse extends AppCompatActivity {
    //need to set the oldid to the course id clicked
    DatabaseAdapter databaseAdapter;
    SqLiteHelper sqLiteHelper = new SqLiteHelper(this);
    EditText newcname ,newcid;
    Button submittBtn;
    String newname ;
        int newid ;
    int oldid ;

    boolean namechanged  = false, idchanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);
        final SQLiteDatabase database = sqLiteHelper.getWritableDatabase();
        Intent intent=getIntent();
        oldid=intent.getIntExtra("oldid",-1);
        this.newcid = findViewById(R.id.newcid);
        this.newcname = findViewById(R.id.newcname);
        this.submittBtn = findViewById(R.id.submitBtn);
        this.databaseAdapter = new DatabaseAdapter(this);


        databaseAdapter.open();
        submittBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newcname.getText().length()>0)
                {
                    newname = newcname.getText().toString();
                    namechanged = true;
                }
                if (newcid.getText().length()>0)
                {
                    newid = Integer.parseInt(newcid.getText().toString());
                    idchanged = true;
                }

                if (namechanged && idchanged)
                {
                    ContentValues cv = new ContentValues();
                    cv.put("course_id",newid);
                    cv.put("course_name",newname);
                    database.update(sqLiteHelper.COURSE_TABLE, cv, sqLiteHelper.COURSE_ID + "="+ oldid, null);
                    newcname.setText("");
                    newcid.setText("");
                }else if(namechanged)
                {
                    ContentValues cv = new ContentValues();
                    cv.put("course_name",newname);
                    database.update(sqLiteHelper.COURSE_TABLE, cv, sqLiteHelper.COURSE_ID + "="+ oldid, null);
                    newcname.setText("");
                }else if(idchanged){
                    ContentValues cv = new ContentValues();
                    cv.put("course_id",newid);
                    database.update(sqLiteHelper.COURSE_TABLE, cv, sqLiteHelper.COURSE_ID + "="+ oldid, null);
                    newcid.setText("");
                }
                else{
                    Toast.makeText(UpdateCourse.this, R.string.no_data, Toast.LENGTH_SHORT).show();
                }
                Intent intent1 = new Intent(getApplicationContext(), ListCoursesActivity.class);
                startActivity(intent1);
            }
        });



        databaseAdapter.close();

    }
}
