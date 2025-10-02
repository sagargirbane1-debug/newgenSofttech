package com.example.StudentManagement.globaleexceptionhandling;

public class AdminNotFoundException extends RuntimeException{
   public AdminNotFoundException(String massage){
        super(massage);
    }
}
