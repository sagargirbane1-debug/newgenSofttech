package com.example.StudentManagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CourseForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;


    private String courseName;

    private String discription;

    private String Duration;

    private double fees;



    // ✅ Owning side: Many courses belong to 1 student

    public CourseForm() {

    }

    public CourseForm(String courseName, String discription, String duration, double fees) {
        this.courseName = courseName;
        this.discription = discription;
        Duration = duration;
        this.fees = fees;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "CourseForm{" +
                "course_id=" + course_id +
                ", courseName='" + courseName + '\'' +
                ", discription='" + discription + '\'' +
                ", Duration='" + Duration + '\'' +
                ", fees=" + fees +
                '}';
    }
}