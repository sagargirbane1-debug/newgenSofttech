package com.example.StudentManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class StudentAddress {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long address_id;

    private String city ;

    private String state ;

    private String contry ;

    @OneToOne(mappedBy = "studentaddress")
    @JsonIgnore
    private StudentResistration studentResistration;

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public StudentResistration getStudentResistration() {
        return studentResistration;
    }

    public void setStudentResistration(StudentResistration studentResistration) {
        this.studentResistration = studentResistration;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "address_id=" + address_id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", contry='" + contry + '\'' +
                ", studentResistration=" + studentResistration +
                '}';
    }
}
