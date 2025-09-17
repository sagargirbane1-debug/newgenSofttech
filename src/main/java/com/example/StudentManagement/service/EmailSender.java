package com.example.StudentManagement.service;

public interface EmailSender {

     void sendEmail(String to, String subject, String body);
}
