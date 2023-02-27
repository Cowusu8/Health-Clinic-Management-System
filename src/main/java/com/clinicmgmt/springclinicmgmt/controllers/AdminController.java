package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.repositories.AdminRepository;
import com.clinicmgmt.springclinicmgmt.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminRepository aRepo;


}
