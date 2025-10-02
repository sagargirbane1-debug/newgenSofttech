package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.StudentResistration;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResistrationRepository extends JpaRepository<StudentResistration, Long> {

//    @EntityGraph(attributePaths = {"studentfeesRecord", "studentaddress"})
//    Optional<StudentResistration> findByid(long id);



}
