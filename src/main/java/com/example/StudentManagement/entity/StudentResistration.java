package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class StudentResistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String student_Name ;

    private long mobileNumber ;

    private String email ;

    private String qualification ;

    private String passing_year ;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

   @JoinColumn(name = "fees_id")
    //@JsonIgnore
    private StudentFeesRecord studentfeesRecord ;

   @OneToOne(cascade = CascadeType.ALL ,     fetch = FetchType.EAGER )
    //@JsonIgnore
   @JoinColumn(name = "address_id")
    private StudentAddress studentaddress ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
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

    public String getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(String passing_year) {
        this.passing_year = passing_year;
    }

    public StudentFeesRecord getStudentFeesRecord() {
        return studentfeesRecord;
    }

    public void setStudentFeesRecord(StudentFeesRecord studentFeesRecord) {
        this.studentfeesRecord = studentFeesRecord;
    }

    public StudentAddress getStudentAddress() {
        return studentaddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentaddress = studentAddress;
    }

    @Override
    public String toString() {
        return "StudentResistration{" +
                "id=" + id +
                ", student_Name='" + student_Name + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", qualification='" + qualification + '\'' +
                ", passing_year='" + passing_year + '\'' +
                ", studentFeesRecord=" + studentfeesRecord +
                ", studentAddress=" + studentaddress +
                '}';
    }
}
