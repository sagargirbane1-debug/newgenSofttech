package com.example.StudentManagement.serviceimpl;

import com.example.StudentManagement.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailSender {

@Autowired
    JavaMailSender javaMailSender;

    @Override
    @Scheduled
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("newgensoftech.pune@gmai.com"); // your Gmail
        message.setTo(to);                       // receiver's email
        message.setSubject(subject);             // subject of mail
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("✅ Mail sent successfully to " + to);
    }
}
