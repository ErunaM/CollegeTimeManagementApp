package com.example.dee.listviewpractice;

/**
 * Created by Dee on 21/03/2017.
 */

public class Days {
    private String dayName;
    private String mainAssignment;

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
