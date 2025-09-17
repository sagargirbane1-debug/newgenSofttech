package com.example.StudentManagement.serviceimpl;


import com.example.StudentManagement.entity.StudentAddress;
import com.example.StudentManagement.entity.StudentFeesRecord;
import com.example.StudentManagement.entity.StudentResistration;
import com.example.StudentManagement.globaleexceptionhandling.StudentNotFoundException;
import com.example.StudentManagement.repository.ResistrationRepository;
import com.example.StudentManagement.service.ResistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResistrationServiceImpl implements ResistrationService {
    @Autowired
    ResistrationRepository resistrationRepository;


    @Override
    public StudentResistration saveNewStudent(StudentResistration student) {

        StudentFeesRecord fees = student.getStudentFeesRecord();

        if (fees != null){
            fees.setRemainngfees( fees.getTotalfees() - fees.getPaidfees());

            fees.setStudentResistration(student);

            student.setStudentFeesRecord(fees);

        }


        StudentAddress address = student.getStudentAddress();


        if (address != null){
            address.setStudentResistration(student);
            student.setStudentAddress(address);
        }

        return resistrationRepository.save(student);

    }

    @Override
    public  StudentResistration getStudent(long id) {
        return resistrationRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException("Student not found with this Id " + id));

    }

    @Override
    public List<StudentResistration> getAll() {
        return resistrationRepository.findAll();
    }

}
