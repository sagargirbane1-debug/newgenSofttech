package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.EnquiryForm;
import com.example.StudentManagement.repository.EnquiryRepository;
import com.example.StudentManagement.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnquiryController {

    @Autowired
    EnquiryService enquiryService;


    EnquiryRepository enquiryRepo ;
    @PostMapping("/new/Enquiry")
    public EnquiryForm newEnquiry(@RequestBody EnquiryForm enquiryForm){
        return enquiryService.newEnquier(enquiryForm);
    }
}
