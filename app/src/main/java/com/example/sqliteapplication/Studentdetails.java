package com.example.sqliteapplication;

public class Studentdetails {

    String name, dob, contact;

    public Studentdetails(String name, String dob, String contact) {

        this.name = name;
        this.dob = dob;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getContact() {
        return contact;
    }
}
