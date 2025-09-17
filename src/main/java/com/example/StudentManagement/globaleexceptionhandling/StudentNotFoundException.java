package com.example.StudentManagement.globaleexceptionhandling;

import com.example.StudentManagement.entity.EnquiryForm;

import java.util.Optional;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String massage){
        super(massage);
    }
}
