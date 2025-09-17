package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
//@Table(name="enquiry_form")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EnquiryForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id")
    private long id;

    private String studentName ;

   // @Column(name = "mobile_number")

    private long mobileNumber ;

   // @Column(name = "email")

    private String email;

    //  @Column(name = "qualification")

    private String qualification ;
   // @Column(name = "passing_year")

    private int passingYear ;

    //@Column(name = "cource_name")

    private String courseName;

    // @Column(name = "course_mode")
    private String courseMode ;

    // @Column(name = "address")
    private String address ;

    @CreationTimestamp
   // @Column(name = "enquirytime")
    private LocalDateTime enquirytime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(String courseMode) {
        this.courseMode = courseMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public LocalDateTime getEnquirytime() {
        return enquirytime;
    }

    public void setEnquirytime(LocalDateTime enquirytime) {
        this.enquirytime = enquirytime;
    }


    @Override
    public String toString() {
        return "EnquiryForm{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                ", passingYear='" + passingYear + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseMode='" + courseMode + '\'' +
                ", address='" + address + '\'' +
                ", enquirytime=" + enquirytime +
                '}';
    }





}
