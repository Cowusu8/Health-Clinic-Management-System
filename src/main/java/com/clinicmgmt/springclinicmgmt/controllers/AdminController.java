package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.dao.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;



@Controller @Slf4j
public class AdminController {
    @Autowired
    private AdminRepo aRepo;

    @GetMapping("Admin") //http://localhost:8080/Admin
    public String showAdmin(){
        log.warn("test");
        return "Admin";
    }
    @GetMapping("admindash") //http://localhost:8080/admindash
    public String showadmindash(){
        log.warn("test");
        return "admindash";
    }


}
