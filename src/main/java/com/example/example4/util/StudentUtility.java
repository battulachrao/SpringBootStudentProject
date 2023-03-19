package com.example.example4.util;

import com.example.example4.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentUtility {


    private static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Tarun","bathula","Ms in cs"));
        studentList.add(new Student(2,"venkat","bathula","networking"));
        studentList.add(new Student(3,"chandu","bathula","java"));
        studentList.add(new Student(4,"teja","bathula","B.Tech"));


    }
    public static List<Student> getStudentList() {
        return studentList;
    }



}
