package com.example.StudentManagement.controller;


import com.example.StudentManagement.entity.CourseForm;
import com.example.StudentManagement.service.CourseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coursesData")
@CrossOrigin("http://localhost:4200")
public class CourcesFormController {

    @Autowired
    CourseFormService courseFormService;


    @PostMapping("/addNewCourse")
    public CourseForm savedata(@RequestBody CourseForm courseForm){
        return courseFormService.SaveNewCourse(courseForm);
    }


    @GetMapping("/getbyid/{id}")
    public  CourseForm getby(@PathVariable long course_id ){
        return courseFormService.getbyid(course_id);
    }

    @GetMapping("/getbycourseName/{courseName}")
    public Optional<CourseForm> getbycourseName(@PathVariable String courseName){
        return courseFormService.getbycourseName(courseName);
    }

    @DeleteMapping("/delete/{courseName}")
    public Optional<CourseForm> deletebycourseName(@PathVariable String courseName){
        return courseFormService.deletebycourseName(courseName);
    }

    @GetMapping("/getAllCourses")
    public List<CourseForm> getAllCourses(){
        return courseFormService.getAllCourse();
    }


    @DeleteMapping("/deleteCourseById/{id}")
    public void deleteCourseById(@PathVariable long id){
       courseFormService.deleteCourseById(id);
    }


    public CourseForm updateCourseData(@PathVariable long id,@RequestBody CourseForm courseForm){
        return courseFormService.updateCourseData(id,courseForm);
    }

}
