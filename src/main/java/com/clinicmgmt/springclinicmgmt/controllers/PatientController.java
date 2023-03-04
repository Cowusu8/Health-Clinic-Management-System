package com.clinicmgmt.springclinicmgmt.controllers;

import java.util.*;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import com.clinicmgmt.springclinicmgmt.repositories.PatientsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller@Slf4j
public class PatientController {

    @Autowired
    private PatientsRepository pRepo;

    @GetMapping({"/showPatients", "/list"})
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("listpatients");
        List<Patients> list = pRepo.findAll();
        mav.addObject("doctors", list);
        return mav;
    }

    @GetMapping("/")
    public String showIndex() {
        log.warn("test");
        return "index";
    }

    @GetMapping("app")
    public String showAppointment() {
        log.warn("test");
        return "appointment";
    }

    @GetMapping("Doctor")
    public String showDoctors() {
        log.warn("test");
        return "Doctors portal";
    }
    @GetMapping("patient")
    public String showPatientportal() {
        log.warn("test");
        return "patientportal";
    }
}


