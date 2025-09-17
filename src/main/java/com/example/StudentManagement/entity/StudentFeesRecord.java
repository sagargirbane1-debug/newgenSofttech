package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity

public class StudentFeesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fees_id ;

    private double totalfees ;

    private double paidfees ;

    private double remainngfees ;

    @OneToOne(mappedBy = "studentfeesRecord")
    @JsonIgnore
    private StudentResistration studentResistration;

    public long getFees_id() {
        return fees_id;
    }

    public void setFees_id(long fees_id) {
        this.fees_id = fees_id;
    }

    public double getTotalfees() {
        return totalfees;
    }

    public void setTotalfees(double totalfees) {
        this.totalfees = totalfees;
    }

    public double getPaidfees() {
        return paidfees;
    }

    public void setPaidfees(double paidfees) {
        this.paidfees = paidfees;
    }

    public double getRemainngfees() {
        return remainngfees;
    }

    public void setRemainngfees(double remainngfees) {
        this.remainngfees = remainngfees;
    }

    public StudentResistration getStudentResistration(StudentResistration student) {
        return studentResistration;
    }

    public void setStudentResistration(StudentResistration studentResistration) {
        this.studentResistration = studentResistration;
    }

    @Override
    public String toString() {
        return "StudentFeesRecord{" +
                "fees_id=" + fees_id +
                ", totalfees=" + totalfees +
                ", paidfees=" + paidfees +
                ", remainngfees=" + remainngfees +
                ", studentResistration=" + studentResistration +
                '}';
    }
}
