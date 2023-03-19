package com.example.example4.Controller;

import com.example.example4.model.Student;
import com.example.example4.model.ValidationException;
import com.example.example4.service.StudentService;
import com.example.example4.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ValidatorUtil validatorUtil;

    @GetMapping("/student/get-all")
    public ResponseEntity<?> getAllStudentList(){
        List<Student> studentList=studentService.getAllStudentList();
        try {
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }catch(Exception ex){
           ex.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/student/get-all/{Student_id}")
    public ResponseEntity<?> getStudent(@PathVariable("Student_id") int Student_id) throws ValidationException,Exception{
        try{
            validatorUtil.validateGetStudent(Student_id);
            return new ResponseEntity<>(studentService.getStudent(Student_id),HttpStatus.OK);
        }catch(ValidationException vex){
            return new ResponseEntity<>(vex.toString(),HttpStatus.BAD_REQUEST);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/student/save")
    public ResponseEntity<?> saveStudents(@RequestBody Student student) throws ValidationException,Exception{
        try {
            validatorUtil.validateSaveStudent(student);
            studentService.saveStudent(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(ValidationException vex){
            return new ResponseEntity<>(vex.toString(),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PutMapping("/student/update")
    public ResponseEntity<?> updateStudents(@RequestBody Student student)throws ValidationException,Exception{
        try {
            validatorUtil.validateUpdateStudent(student);
            studentService.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(ValidationException vex){
            return new ResponseEntity<>(vex.toString(),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @DeleteMapping("/student/delete/{Student_id}")
    public ResponseEntity<?> delStudent(@PathVariable("Student_id") int Student_id)throws ValidationException{
        try
        {
            validatorUtil.validateDeleteStudent(Student_id);
            studentService.deleteStudent(Student_id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(ValidationException vex){
            return new ResponseEntity<>(vex.toString(),HttpStatus.BAD_REQUEST);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/student/search")
    public ResponseEntity<?> getStudent(@RequestParam("searchStr") String searchStr) throws ValidationException{
        try {
            validatorUtil.ValidateSearchStudent(searchStr);
            return new ResponseEntity<>(studentService.searchStudent(searchStr), HttpStatus.OK);
        }catch(ValidationException vex){
            return new ResponseEntity<>(vex.toString(),HttpStatus.BAD_REQUEST);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
