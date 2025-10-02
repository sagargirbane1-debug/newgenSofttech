package com.example.StudentManagement.service;

import com.example.StudentManagement.entity.CourseForm;

import java.util.List;
import java.util.Optional;

public interface CourseFormService {

    CourseForm SaveNewCourse(CourseForm courseForm);


    CourseForm getbyid(long course_id);


    Optional<CourseForm> getbycourseName(String courseName);


    Optional<CourseForm> deletebycourseName(String courseName);

    List<CourseForm> getAllCourse();


    void deleteCourseById(long id);

    CourseForm updateCourseData (long id,CourseForm updatedData);

}
