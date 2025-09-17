package com.example.StudentManagement.controller;

import com.example.StudentManagement.constant.Constants;
import com.example.StudentManagement.entity.EnquiryForm;
import com.example.StudentManagement.service.EmailSender;
import com.example.StudentManagement.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    EmailSender emailSender;


    // ==============================
    // Create a new enquiry
    // ==============================

    @PostMapping("/newEnquiry")
    public EnquiryForm newEnquiry(@RequestBody EnquiryForm enquiryForm) {

        emailSender.sendEmail(enquiryForm.getEmail(),"About Our Class","Dear, "+
                enquiryForm.getStudentName() + Constants.course_information  + Constants.regards);
        return enquiryService.saveNewEnqury(enquiryForm);
    }




    // ==============================
    // Get enquiry by ID
    // ==============================

    @GetMapping("/getStudent/{id}")
    public EnquiryForm getStudentById(@PathVariable Long id) {
        return enquiryService.getEnquiryStudent(id);
    }

    // ==============================
    // Get all enquiries
    // ==============================

    @GetMapping("/getAllEquiries")
    public List<EnquiryForm> getAll() {
        return enquiryService.getAllEnquiries();
    }

    // ==============================
    // Update enquiry by ID
    // ==============================

    @PutMapping("/updateEnquiry")
    public ResponseEntity<EnquiryForm> updateEnquiry(@RequestBody EnquiryForm enquiryForm,
                                                     @RequestParam Long id) {
        return enquiryService.UpdateEnquiry(id, enquiryForm);
    }

    // ==============================
    // Delete enquiry by ID
    // ==============================

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id) {
        enquiryService.deleteByid(id);
        return "Record deleted Successfully with Id: " + id;
    }

    // ==============================
    // Delete all enquiries
    // ==============================

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        enquiryService.deleteAllEnquierdata();
        return "All Enquiries deleted Successfully";
    }
}
