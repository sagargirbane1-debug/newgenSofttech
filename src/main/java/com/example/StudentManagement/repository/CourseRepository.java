package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.CourseForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<CourseForm , Long > {


    Optional<CourseForm> findBycourseName(String courseName);


    Optional<CourseForm> deleteBycourseName(String courseName);

}
