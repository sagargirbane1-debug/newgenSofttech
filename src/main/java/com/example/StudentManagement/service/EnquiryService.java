package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.EnquiryForm;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EnquiryService {

    EnquiryForm saveNewEnqury(EnquiryForm enquiryForm);

    EnquiryForm getEnquiryStudent(long id);

    List<EnquiryForm> getAllEnquiries();

    ResponseEntity<EnquiryForm> UpdateEnquiry(long id , EnquiryForm enquiryForm);

    void deleteByid(long id);

    void deleteAllEnquierdata();

}
