package com.example.StudentManagement.repository;


import com.example.StudentManagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Long> {
    Optional<Admin> FindByEmail(String email);
}
