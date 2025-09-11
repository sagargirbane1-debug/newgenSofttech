package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.EnquiryForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryForm , Long> {
}
