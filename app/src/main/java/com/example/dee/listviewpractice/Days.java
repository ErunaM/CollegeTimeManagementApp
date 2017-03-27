package com.example.dee.listviewpractice;

/**
 * Created by Dee on 21/03/2017.
 */
//Day class will hold my mon-sunday days will also store the MainAssignment to display in my first listview
public class Days {
    private String dayName;
    private String mainAssignment;
    public Assignments[] assignmentArray[]; // used to hold all my assignments in a day
    private int dayId; // hold id in our data base

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public Days()
    {}


    public String getDays() {
        return dayName;
    }

    public void setDays(String days) {
        this.dayName = days;
    }

    public String getMainAssignment() {
        return mainAssignment;
    }

    public void setMainAssignment(String mainAssignment) {
        this.mainAssignment = mainAssignment;
    }

    public Days(String days) {
        this.dayName = days;
    }
}
