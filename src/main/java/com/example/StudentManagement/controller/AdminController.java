package com.example.StudentManagement.controller;


import com.example.StudentManagement.entity.Admin;
import com.example.StudentManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Admin")
public class AdminController {


    @Autowired
    AdminService adminService;



    @PostMapping("Sent/otp")
    public String getotp(@RequestParam String email){
        String otp = adminService.genrateotp(email);
        return " Otp sent Successfully to " + email;
    }


}
