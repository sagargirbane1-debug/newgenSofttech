package com.example.StudentManagement.controller;


import com.example.StudentManagement.entity.StudentResistration;
import com.example.StudentManagement.service.ResistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resistration_form")
public class ResistrationController {

    @Autowired
    ResistrationService resistrationService ;

    @PostMapping("/SaveResister/student")
    public StudentResistration saveresisterStudent(@RequestBody StudentResistration student){
        return resistrationService.saveNewStudent(student);
    }
    @GetMapping("/get/{id}")
    public StudentResistration getbyid(@PathVariable long id){
        return resistrationService.getStudent(id);
    }
    @GetMapping("/getAll")
    public List<StudentResistration> getall(){
        return resistrationService.getAll();
    }
}
