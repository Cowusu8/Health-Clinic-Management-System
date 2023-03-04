package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.repositories.DoctorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  @Slf4j
public class DoctorController {

    @Autowired
    private DoctorsRepository dRepo;

    @GetMapping("docs")
    public String showdoc(){
        log.warn("test");
        return "doc";
    }


    @GetMapping("docportal")
    public String showdoctorsportal(){
        log.warn("test");
        return "doctorsportal";
    }

}
