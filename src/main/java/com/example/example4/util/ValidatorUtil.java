package com.example.example4.util;

import com.example.example4.model.Student;
import com.example.example4.model.ValidationException;
import com.example.example4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class ValidatorUtil {
    @Autowired
    private StudentService studentService;

    public void throwValidationException(Boolean ShouldThrow, String errorCode, String errorMsg) throws ValidationException {
        if(ShouldThrow){
            throw new ValidationException(errorCode,errorMsg);
        }
    }
    public boolean isEmpty(int a){
        return a==0?true:false;
    }
    public boolean isNull(String s){
        return s == null || ("".equals(s.trim())) ? true : false;

    }


     public void validateGetStudent(int Student_id)throws ValidationException {
         throwValidationException(isEmpty(Student_id),"STUDENT_GET_01", "Student_id can not be 0");
         throwValidationException(studentService.getStudent(Student_id)==null,"STUDENT_GET_02","Student_id "+Student_id+" was not found");
        /*if(Student_id==0) {
            throw new ValidationException("STUDENT_GET_01", "Student_id can not be 0");
        }
        if(studentService.getStudent(Student_id)==null){
            throw new ValidationException("STUDENT_GET_02","Student_id "+Student_id+" was not found");
        }*/
    }
    public void validateSaveStudent(Student student)throws ValidationException {
        throwValidationException(student == null,"STUDENT_save_01", "Student can not be empty");
        throwValidationException(isEmpty(student.getStudentId()),"STUDENT_save_02", "Student_id can not be empty");
        throwValidationException(student.getfName() == null || "".equals(student.getfName().trim()),"STUDENT_save_03", "Student_fName can not be empty");
        throwValidationException(student.getlName() == null || "".equals(student.getlName().trim()),"STUDENT_save_04", "Student_lName can not be empty");
        throwValidationException(student.getCourse() == null || "".equals(student.getCourse().trim()), "STUDENT_save_05", "Student_Course can not be empty");
        throwValidationException(studentService.getStudent(student.getStudentId()) != null,"STUDENT_save_06", student.getStudentId() + "Student_id already exists");

        /*if (student == null) {
            throw new ValidationException("STUDENT_save_01", "Student can not be empty");
        }
        if (student.getStudentId() == 0) {
            throw new ValidationException("STUDENT_save_02", "Student_id can not be empty");
        }
        if (student.getfName() == null || "".equals(student.getfName().trim())) {
            throw new ValidationException("STUDENT_save_03", "Student_fName can not be empty");

        }
        if (student.getlName() == null || "".equals(student.getlName().trim())) {
            throw new ValidationException("STUDENT_save_04", "Student_lName can not be empty");
        }
        if (student.getCourse() == null || "".equals(student.getCourse().trim())) {
            throw new ValidationException("STUDENT_save_04", "Student_Course can not be empty");
        }
        if (studentService.getStudent(student.getStudentId()) != null) {
            throw new ValidationException("STUDENT_save_05", student.getStudentId() + "Student_id already exists");
        }*/
    }
    public void validateUpdateStudent(Student student)throws ValidationException {
        throwValidationException(student==null,"STUDENT_UPDATE_01", "Student can not be empty");
        throwValidationException(isEmpty(student.getStudentId()),"STUDENT_UPDATE_02","Student_id can not be empty");
        throwValidationException(student.getfName() == null || "".equals(student.getfName().trim()),"STUDENT_UPDATE_03","Student_fName can not be empty");
        throwValidationException(student.getlName()==null || "".equals(student.getlName().trim()),"STUDENT_UPDATE_04","Student_lName can not be empty");
        throwValidationException(student.getCourse()==null || "".equals(student.getCourse().trim()),"STUDENT_UPDATE_05","Student_Course can not be empty");
        throwValidationException(studentService.getStudent(student.getStudentId())==null,"STUDENT_UPDATE_06",student.getStudentId()+" Student_id was not");
         /*if(student==null) {
             throw new ValidationException("STUDENT_UPDATE_01", "Student can not be empty");
         }
         if(student.getStudentId() == 0){
             throw new ValidationException("STUDENT_UPDATE_02","Student_id can not be empty");
         }
         if(student.getfName() == null || "".equals(student.getfName().trim())){
             throw new ValidationException("STUDENT_UPDATE_03","Student_fName can not be empty");

         }
         if(student.getlName()==null || "".equals(student.getlName().trim())){
             throw new ValidationException("STUDENT_UPDATE_04","Student_lName can not be empty");
         }
         if(student.getCourse()==null || "".equals(student.getCourse().trim())){
             throw new ValidationException("STUDENT_UPDATE_05","Student_Course can not be empty");
         }
         if(studentService.getStudent(student.getStudentId())==null){
             throw new ValidationException("STUDENT_UPDATE_06",student.getStudentId()+" Student_id was not");
         }*/
    }
    public void validateDeleteStudent(int Student_id)throws ValidationException {
        throwValidationException(isEmpty(Student_id),"STUDENT_DEL_01", "Student_id can not be 0");
        throwValidationException(studentService.getStudent(Student_id)==null,"STUDENT_DEL_02","Student_id "+Student_id+" was not found");
        /*if(Student_id==0) {
            throw new ValidationException("STUDENT_DEL_01", "Student_id can not be 0");
        }
        if(studentService.getStudent(Student_id)==null){
            throw new ValidationException("STUDENT_DEL_02","Student_id "+Student_id+" was not found");
        }*/
    }
    public void ValidateSearchStudent(String str)throws ValidationException{
        throwValidationException(str==null || "".equals(str.trim()),"STUDENT_SEARCH_01"," Search string can not be empty");
         /*if(str==null || "".equals(str.trim())){
             throw new ValidationException("STUDENT_SEARCH_01"," Search string can not be empty");
         }*/
    }

}
