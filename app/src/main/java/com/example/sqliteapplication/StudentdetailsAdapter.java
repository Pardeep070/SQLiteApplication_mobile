package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentdetailsAdapter extends ArrayAdapter {
    Context mContext;
    int layoutRes;
    List<Studentdetails> studentdetails;
    //    SQLiteDatabase mDatabase;
    DBHelper mDatabase;

    public StudentdetailsAdapter(Context mContext, int layoutRes, List<Studentdetails> studentdetails, DBHelper mDatabase) {
        super(mContext, layoutRes, studentdetails);
        this.mContext = mContext;
        this.layoutRes = layoutRes;
        this.studentdetails = studentdetails;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(layoutRes, null);
        TextView tvName = v.findViewById(R.id.tv_name);
        TextView tvContact = v.findViewById(R.id.tv_contact);
        TextView tvDob = v.findViewById(R.id.tv_dob);


        final Studentdetails studentdetails = this.studentdetails.get(position);
        tvName.setText(studentdetails.getName());
        tvContact.setText(studentdetails.getContact());
        tvDob.setText(studentdetails.getDob());

        return v;
    }

}
