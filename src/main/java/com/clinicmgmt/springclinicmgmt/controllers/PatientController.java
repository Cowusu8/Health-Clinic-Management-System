package com.clinicmgmt.springclinicmgmt.controllers;

import java.util.*;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import com.clinicmgmt.springclinicmgmt.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller@Slf4j
public class PatientController {

    @Autowired
    private PatientRepository pRepo;

    @GetMapping({"/showPatients", "/list"})
    public ModelAndView showPatient() {
        ModelAndView mav = new ModelAndView("listpatients");
        List<Patient> list= pRepo.findAll();
        mav.addObject("patient", list);
        return mav;
    }
   @GetMapping("/")
        public String showIndex (){
            log.warn("test");
        return "index";
   }

    @GetMapping("app")
    public String showAppointment (){
        log.warn("test");
        return "appointment";
    }
    @GetMapping("Admin")
    public String showAdminportal(){
        log.warn("test");
        return "Adminportal";
    }
    @GetMapping("Doctor")
    public String showDoctorportal(){
        log.warn("test");
        return "Doctorportal";
    }
}
