package com.example.sqliteapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentdetailsActivity extends AppCompatActivity {

    private static final String TAG = "StudentActivity";

    DBHelper mDatabase;
    List<Studentdetails> studentdetailsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        listView = findViewById(R.id.lvStudent);
        studentdetailsList = new ArrayList<>();

        mDatabase = new DBHelper(this);
        loadEmployees();
    }

    private void loadEmployees() {

        Cursor cursor = mDatabase.getdata();

        if (cursor.moveToFirst()) {
            do {
                studentdetailsList.add(new Studentdetails(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
            cursor.close();

            StudentdetailsAdapter studentdetailsAdapter = new StudentdetailsAdapter(this, R.layout.list_layout_student, studentdetailsList, mDatabase);
            listView.setAdapter(studentdetailsAdapter);

        }
    }

}


