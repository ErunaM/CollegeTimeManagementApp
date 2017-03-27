package com.example.dee.listviewpractice;

import com.example.dee.listviewpractice.AssignmentInterface;

/**
 * Created by Dee on 27/03/2017.
 */
///Class that will hold the assignment data that is used for my Day Scheduling
public class Assignments implements AssignmentInterface {
    private String Assignment;
    private String AssignmentTitle;

    public String getAssignment() { // get current assignment
        return Assignment;
    }

    public void setAssignment(String assignment) { // set Current Assignment
        Assignment = assignment;
    }

    public String getAssignmentTitle() { // get Assignment Title
        return AssignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) { // Set Assignment Title
        AssignmentTitle = assignmentTitle;
    }
}
