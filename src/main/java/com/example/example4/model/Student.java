package com.example.example4.model;

public class Student {
    private int StudentId;
    private String fName;
    private String lName;
    private String course;
    //
    public Student(){
        super();
    }

    public Student(int studentId, String fName, String lName, String course) {
        this();
        StudentId = studentId;
        this.fName = fName;
        this.lName = lName;
        this.course = course;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
