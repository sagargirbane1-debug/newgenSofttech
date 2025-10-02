package com.example.StudentManagement.serviceimpl;

import com.example.StudentManagement.entity.CourseForm;
import com.example.StudentManagement.entity.StudentAddress;
import com.example.StudentManagement.entity.StudentFeesRecord;
import com.example.StudentManagement.entity.StudentResistration;
import com.example.StudentManagement.globaleexceptionhandling.StudentNotFoundException;
import com.example.StudentManagement.repository.FeesRecordRepository;
import com.example.StudentManagement.repository.ResistrationRepository;
import com.example.StudentManagement.service.EmailSender;
import com.example.StudentManagement.service.ResistrationService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ResistrationServiceImpl implements ResistrationService {

    @Autowired
    private ResistrationRepository resistrationRepository;

    @Autowired
    private EmailSender emailSender;




    @Override
    public StudentResistration saveNewStudent(StudentResistration student) {


      StudentFeesRecord feesRecord = new StudentFeesRecord();
        feesRecord.setPaidfees(0);
        feesRecord.setTotalfees(40000);
        feesRecord.setRemainngfees(feesRecord.getTotalfees());


        student.setStudentFeesRecord(feesRecord);

        feesRecord.getStudentResistration(student);



        StudentAddress address = new StudentAddress();
        address.setCity(student.getStudentAddress().getCity());
        address.setContry(student.getStudentAddress().getContry());
        address.setState(student.getStudentAddress().getState());


        address.setStudentResistration(student);
        student.setStudentAddress(address);




        return resistrationRepository.save(student);
    }


    private void sendWelcomeEmail(StudentResistration student) {
        String subject = "Welcome " + student.getStudent_Name() + " To Our Institute !!!";
        StringBuilder body = new StringBuilder();

        body.append("Hello ").append(student.getStudent_Name()).append(",\n\n");
        body.append("🎉 You have successfully registered!\n\n");



        // Fees info
        if (student.getStudentFeesRecord() != null) {
            body.append("\n💰 Fees Summary:\n")
                    .append(" Total Fees : ").append(student.getStudentFeesRecord().getTotalfees()).append("\n")
                    .append(" Paid Fees : ").append(student.getStudentFeesRecord().getPaidfees()).append("\n")
                    .append(" Remaining Fees : ").append(student.getStudentFeesRecord().getRemainngfees()).append("\n");
        }

        // Address
        body.append("\n📍 Address: ")
                .append(student.getStudentAddress() != null ? student.getStudentAddress().getCity() : "N/A");

        body.append("\n\nThank you for joining us!\nInstitute Team");

        emailSender.sendEmail(student.getEmail(), subject, body.toString());
    }

    @Override
    public StudentResistration getStudent(long id) {
        return resistrationRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("Student not found with this Id " + id));
    }

    @Override
    public List<StudentResistration> getAll() {
        return resistrationRepository.findAll();
    }

    @Override
    public String addFees(long id, double fees) {

        Optional<StudentResistration> optionalStudentResistration  =resistrationRepository.findById(id);
        if (optionalStudentResistration.isEmpty()){
            throw new StudentNotFoundException("this id is not present");
        }
        StudentResistration studentResistration=  optionalStudentResistration.get();

        studentResistration.getStudentFeesRecord().setPaidfees(studentResistration.getStudentFeesRecord().getPaidfees() + fees);
        studentResistration.getStudentFeesRecord().setRemainngfees(studentResistration.getStudentFeesRecord().getTotalfees() - studentResistration.getStudentFeesRecord().getPaidfees());
        resistrationRepository.save(studentResistration);
        return "";
    }


    @Autowired
    FeesRecordRepository feesRepo;

    public Map<String, Double> getFeeSummary() {
        Map<String, Double> summary = new HashMap<>();
        summary.put("totalFees", feesRepo.getTotalFees() != null ? feesRepo.getTotalFees() : 0);
        summary.put("totalPaid", feesRepo.getTotalPaidFees() != null ? feesRepo.getTotalPaidFees() : 0);
        summary.put("totalPending", feesRepo.getTotalPendingFees() != null ? feesRepo.getTotalPendingFees() : 0);
        return summary;
    }
}

