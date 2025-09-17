package com.example.StudentManagement.service;


import com.example.StudentManagement.entity.StudentResistration;

import java.util.List;

public interface ResistrationService {

    StudentResistration saveNewStudent(StudentResistration student);


    StudentResistration getStudent(long id);


    List<StudentResistration> getAll();
}
