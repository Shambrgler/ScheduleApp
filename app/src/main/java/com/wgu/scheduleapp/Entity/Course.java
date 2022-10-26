package com.wgu.scheduleapp.Entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "courses")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private String courseTitle;
    private String courseStartDate;
    private String courseEndDate;
    private boolean hasTerm = false;
    private String termName;
    private String instructor;
    private String phoneNumber;
    private String email;
    private String note;
    private String status;
    @Ignore
    private List<Assessment> courseAssessments;

    public Course(String courseTitle, String courseStartDate, String courseEndDate, String instructor, String phoneNumber, String email, String note, String status) {
        this.courseTitle = courseTitle;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.instructor = instructor;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.note = note;
        this.status = status;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getCourseID() { return courseID; }

    public void setCourseID(int courseID) { this.courseID = courseID; }

    public String getCourseTitle() { return courseTitle; }

    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }

    public String getCourseStartDate() { return courseStartDate; }

    public void setCourseStartDate(String courseStartDate) { this.courseStartDate = courseStartDate; }

    public String getCourseEndDate() { return courseEndDate; }

    public void setCourseEndDate(String courseEndDate) { this.courseEndDate = courseEndDate; }

    public boolean isHasTerm() { return hasTerm; }

    public void setHasTerm(boolean hasTerm) { this.hasTerm = hasTerm;}

    public String getTermName() { return termName; }

    public void setTermName(String termName) { this.termName = termName; }

    public String getInstructor() { return instructor; }

    public void setInstructor(String instructor) { this.instructor = instructor; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public List<Assessment> getCourseAssessments() {
        //TODO: Query assessments table for all assessments with courseID;
        if (courseAssessments.isEmpty()) {
            return null;
        } else {
            return courseAssessments;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseStartDate='" + courseStartDate + '\'' +
                ", courseEndDate='" + courseEndDate + '\'' +
                ", hasTerm=" + hasTerm +
                ", termName='" + termName + '\'' +
                '}';
    }
}
