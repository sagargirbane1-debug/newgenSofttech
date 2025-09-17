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
}
