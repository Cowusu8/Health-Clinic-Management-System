package org.crystalowusu.springclinicmgmt.controllers;


import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
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

    @GetMapping("/patients")
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("list_patients");
        List<Patient> patient = pRepo.findAll();
        mav.addObject("patients", patient);
        return mav;
    }

    @GetMapping("/addPatientsForm")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add_patient_form");
        Patient patient = new Patient();
        mav.addObject("patient", patient);
        return mav;
    }

    @PostMapping("/savePatients")
    public String savePatient(@ModelAttribute Patient patient) {
        pRepo.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/showUpdatePatient")
    public ModelAndView showUpdateForm(@RequestParam Long patientId) {
        ModelAndView mav = new ModelAndView("add_patient_form");
        Patient patient = pRepo.findById(patientId).get();
        mav.addObject("patients", patient);
        return mav;
    }

    @GetMapping("/deletePatient")
    public String deletePatients(@RequestParam Long patientId) {
        pRepo.deleteById(patientId);
        return "redirect:/patients";
    }



//    @GetMapping("app")
//    public String showAppointment() {
//        log.warn("test");
//        return "appointment";
//    }

//    @GetMapping("patient")
//    public String showPatientportal() {
//        log.warn("test");
//        return "listpatients";
//    }


}


