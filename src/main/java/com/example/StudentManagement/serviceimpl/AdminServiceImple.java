package com.example.StudentManagement.serviceimpl;


import com.example.StudentManagement.entity.Admin;
import com.example.StudentManagement.globaleexceptionhandling.AdminNotFoundException;
import com.example.StudentManagement.repository.AdminRepository;
import com.example.StudentManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AdminServiceImple implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public String genrateotp(String email){
        Optional<Admin> otpgenerate = adminRepository.FindByEmail(email);
        if (otpgenerate.isEmpty()){
            throw new AdminNotFoundException("please check your if email is correct " +
                    "\n then you dont have any acssess now to login as admin " +
                    "\n" +
                    "please contact with your manager " + email);
        }
        Admin admin = otpgenerate.get();

        String  otp = String.valueOf(100000 + new Random().nextInt(900000));

        return otp ;
    }
}
