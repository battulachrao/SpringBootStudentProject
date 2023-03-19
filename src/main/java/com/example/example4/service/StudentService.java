package com.example.example4.service;

import com.example.example4.model.Student;
import com.example.example4.util.StudentUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudentList(){
        return StudentUtility.getStudentList();
    }
    public Student getStudent(int studentId){
        List<Student> studentList=StudentUtility.getStudentList();
        for(Student student:studentList){
            if(student.getStudentId()==studentId){
                return student;
            }
        }
        return null;
    }
    public void saveStudent(Student student){
        StudentUtility.getStudentList().add(student);
    }
    public void updateStudent(Student nstudent){
        for(Student ostudent:StudentUtility.getStudentList()){
            if(ostudent.getStudentId()==nstudent.getStudentId()){
                ostudent.setfName(nstudent.getfName());
                ostudent.setlName(nstudent.getlName());
                ostudent.setCourse(nstudent.getCourse());
                break;
            }
        }

    }
    public void deleteStudent(int studentId){
        StudentUtility.getStudentList().remove(getStudent(studentId));
       /* List<Student> studentList=StudentUtility.getStudentList();
        for(Student student:studentList){
            if(student.getStudentId()==studentId){
                studentList.remove(student);

            }
        }
        return null;*/
    }
    public List<Student> searchStudent(String searchStudent){
        searchStudent=searchStudent.toLowerCase();
        List<Student> studentList=getAllStudentList();
        List<Student> rList= new ArrayList<>();
        for(Student s: studentList){
            if(Integer.toString(s.getStudentId()).contains(searchStudent) || s.getfName().toLowerCase().contains(searchStudent)
            || s.getlName().toLowerCase().contains(searchStudent) || s.getCourse().toLowerCase().contains(searchStudent)){
                rList.add(s);
            }
        }

        return rList;
    }

}
