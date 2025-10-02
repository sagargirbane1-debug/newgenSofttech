package com.example.StudentManagement.service;

import org.springframework.scheduling.annotation.Async;

public interface EmailSender {


     @Async
     void sendEmail(String to, String subject, String body);

}
