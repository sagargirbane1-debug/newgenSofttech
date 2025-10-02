package com.example.StudentManagement.globaleexceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobleExceptionHandling {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String , Object>> HandleStudentNotFound(StudentNotFoundException ex){
        Map<String ,Object> errorRespounce = new HashMap<>();
        errorRespounce.put(" timestamp " , LocalDateTime.now());
        errorRespounce.put(" Status" , HttpStatus.NOT_FOUND.value());
        errorRespounce.put(" error" , "You need to Add Student with this Id ");
        errorRespounce.put(" massqage" , ex.getMessage());
        return new ResponseEntity<>(errorRespounce,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdminNotFoundException.class)

    public ResponseEntity<Map<String , Object>> HandleAdminNotException (AdminNotFoundException ex){
        Map<String , Object> adminerror = new HashMap<>();
        adminerror.put("timestamp " , LocalDateTime.now());
        adminerror.put("Status " , HttpStatus.NOT_FOUND.value());
        adminerror.put("error " , " you dont have any acsses yet to log in as admin");
        adminerror.put("massage " , ex.getMessage());

        return new ResponseEntity<>(adminerror,HttpStatus.NOT_FOUND);
    }
}
