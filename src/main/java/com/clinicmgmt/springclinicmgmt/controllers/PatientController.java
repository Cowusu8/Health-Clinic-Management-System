package com.clinicmgmt.springclinicmgmt.controllers;

import java.util.*;

import com.clinicmgmt.springclinicmgmt.dao.PatientsRepo;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller@Slf4j
public class PatientController {

    @Autowired
    private PatientsRepo pRepo;

    @GetMapping({"/showPatients", "/patients"})
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("listpatients");
        List<Patient> patients = pRepo.findAll();
        mav.addObject("patients", patients);
        return mav;
    }

    @GetMapping("/addPatientsForm")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient patient = new Patient();
        mav.addObject("patient", patient);
        return mav;
    }

    @PostMapping("/savePatients")
    public String savePatient(@ModelAttribute Patient patient) {
        pRepo.save(patient);
        return "redirect:/patient";
    }

    @GetMapping("/showUpdatePatient")
    public ModelAndView showUpdateForm(@RequestParam Long patientId) {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient patient = pRepo.findById(patientId).get();
        mav.addObject("patient", patient);
        return mav;
    }

    @GetMapping("/deletePatient")
    public String deletePatients(@RequestParam Long patientId) {
        pRepo.deleteById(patientId);
        return "redirect:/patients";
    }

    /*@GetMapping("/")
    public String showIndex() {
        log.warn("test");
        return "index";
    }*/

    @GetMapping("app")
    public String showAppointment() {
        log.warn("test");
        return "appointment";
    }

    @GetMapping("patient")
    public String showPatientportal() {
        log.warn("test");
        return "patientportal";
    }


}


