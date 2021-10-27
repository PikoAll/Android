package com.example.database.Database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity      //obbligatorio
public class user {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)  //genera id univoco ogni volta
    private int id;

    @ColumnInfo(name = "first name")
    private String name;
    @ColumnInfo(name = "last name")
    private String lastName;


    @Ignore
    public user() {

    }

    public user(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
