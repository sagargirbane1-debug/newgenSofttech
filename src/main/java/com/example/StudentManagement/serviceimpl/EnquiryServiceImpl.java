package com.example.StudentManagement.serviceimpl;

import com.example.StudentManagement.entity.CourseForm;
import com.example.StudentManagement.entity.EnquiryForm;
import com.example.StudentManagement.globaleexceptionhandling.StudentNotFoundException;
import com.example.StudentManagement.repository.EnquiryRepository;
import com.example.StudentManagement.service.EmailSender;
import com.example.StudentManagement.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnquiryServiceImpl implements EnquiryService {


    @Autowired
    EnquiryRepository enquiryRepository;



    @Autowired
    EmailSender emailSender;

    // ==============================
    // Save new enquiry
    // ==============================


    @Override
    public EnquiryForm saveNewEnqury(EnquiryForm enquiryForm) {


        return enquiryRepository.save(enquiryForm);


    }
    @Override
    public EnquiryForm getEnquiryStudent(long id) {
        return enquiryRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not Found for this Id " + id));
    }

    // ==============================
    // Get all enquiries
    // ==============================
    @Override
    public List<EnquiryForm> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    // ==============================
    // Update enquiry by ID
    // ==============================
    @Override
    public ResponseEntity<EnquiryForm> UpdateEnquiry(long id, EnquiryForm enquiryForm) {
        Optional<EnquiryForm> existEnquier = enquiryRepository.findById(id);

        if (existEnquier.isPresent()) {
            EnquiryForm enquiryForm2 = existEnquier.get();
            enquiryForm2.setStudentName(enquiryForm.getStudentName());
//            enquiryForm2.setEmail(enquiryForm.getEmail());
            enquiryForm2.setMobileNumber(enquiryForm.getMobileNumber());

            EnquiryForm updatedEnquiry = enquiryRepository.save(enquiryForm2);
            return ResponseEntity.ok(updatedEnquiry);
        }

        return ResponseEntity.notFound().build();
    }

    // ==============================
    // Delete enquiry by ID
    // ==============================
    @Override
    public void deleteByid(long id) {
        enquiryRepository.deleteById(id);
    }

    // ==============================
    // Delete all enquiries
    // ==============================
    @Override
    public void deleteAllEnquierdata() {
        enquiryRepository.deleteAll();
    }
}
