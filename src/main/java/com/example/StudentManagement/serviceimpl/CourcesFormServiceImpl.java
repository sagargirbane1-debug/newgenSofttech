package com.example.StudentManagement.serviceimpl;

import com.example.StudentManagement.entity.CourseForm;
import com.example.StudentManagement.globaleexceptionhandling.StudentNotFoundException;
import com.example.StudentManagement.repository.CourseRepository;
import com.example.StudentManagement.service.CourseFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourcesFormServiceImpl implements CourseFormService {


    @Autowired
    CourseRepository courseRepository;
    @Override
    public CourseForm SaveNewCourse(CourseForm courseForm) {

        return  courseRepository.save(courseForm);
    }

    @Override
    public CourseForm getbyid(long course_id) {
        return courseRepository.findById(course_id).orElseThrow(()->
                new StudentNotFoundException("Student not Found for this Id " + course_id));
    }

    @Override
    public Optional<CourseForm> getbycourseName(String courseName) {
        return courseRepository.findBycourseName(courseName);
    }

    @Override
    public Optional<CourseForm> deletebycourseName(String courseName) {
        return courseRepository.deleteBycourseName(courseName);
    }

    @Override
    public List<CourseForm> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(long id) {
  courseRepository.findById(id).orElseThrow(()->
          new StudentNotFoundException("Course with id : "+ id + "is not present ") );

  courseRepository.deleteById(id);



    }

    @Override
    public CourseForm updateCourseData(long id, CourseForm updatedData) {
        Optional<CourseForm> optionalCourseForm  =courseRepository.findById(id);
        if (optionalCourseForm.isEmpty()){
            throw new StudentNotFoundException("this id is not present");
        }
CourseForm currentData =  optionalCourseForm.get();

        if (updatedData.getCourseName()!= null && !updatedData.getCourseName().isEmpty()){
            currentData.setCourseName(updatedData.getCourseName());
        }
        if (updatedData.getDiscription()!= null && !updatedData.getDiscription().isEmpty()){
            currentData.setDiscription(updatedData.getDiscription());
        }

        if (updatedData.getFees() != 0){
            currentData.setFees(updatedData.getFees());
        }



        return courseRepository.save(currentData);
    }

}

