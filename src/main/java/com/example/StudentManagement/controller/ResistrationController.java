package com.example.StudentManagement.controller;


import com.example.StudentManagement.entity.StudentResistration;
import com.example.StudentManagement.service.ResistrationService;
import com.example.StudentManagement.serviceimpl.ResistrationServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resistration_form")
public class ResistrationController {

    @Autowired
    ResistrationService resistrationService ;

    @PostMapping("/saveNewStudent")
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

    @PutMapping("/addFees/{id}/{fees}")
    public String addfees(@PathVariable long id, @PathVariable double fees){
        resistrationService.addFees(id,fees);
        return "fees deposited";
    }

@Autowired
    ResistrationServiceImpl feesService;

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Double>> getFeeSummary() {
        return ResponseEntity.ok(feesService.getFeeSummary());
    }





    @GetMapping("/export-excel")
    public ResponseEntity<byte[]> exportstudentToexcel() throws IOException{
        List<StudentResistration> students =  resistrationService.getAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Registered Students");

        // Create header row
        Row header = sheet.createRow(0);
        String[] columns = {
                "ID", "Name", "Email", "Mobile", "Qualification",
                "Passing Year", "Address", "Total Fees", "Paid Fees", "Remaining Fees"
        };
        for (int i = 0; i < columns.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Add student data
        int rowIdx = 1;
        for (StudentResistration s : students) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(s.getId());
            row.createCell(1).setCellValue(s.getStudent_Name() != null ? s.getStudent_Name() : "N/A");
            row.createCell(2).setCellValue(s.getEmail() != null ? s.getEmail() : "N/A");
            row.createCell(3).setCellValue( s.getMobileNumber());
            row.createCell(4).setCellValue(s.getQualification() != null ? s.getQualification() : "N/A");
            row.createCell(5).setCellValue(s.getPassing_year() != null ? s.getPassing_year() : "N/A");
            row.createCell(6).setCellValue(
                    (s.getStudentAddress() != null)
                            ? s.getStudentAddress().getCity() + ", " + s.getStudentAddress().getState()
                            : "N/A"
            );
        }

        // Auto size columns
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write to output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        byte[] bytes = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=RegisteredStudents.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }
}

