package org.crystalowusu.springclinicmgmt.controllers;

import java.util.*;

import jakarta.servlet.http.HttpSession;
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller @Slf4j
public class PatientController {

    @Autowired
    private PatientsRepo patientsRepo;

    @GetMapping({"/patlist"})
    public ModelAndView getAllPatient() {
        ModelAndView mav = new ModelAndView("listpatients");
        mav.addObject("patient", patientsRepo.findAll());
        return mav;
    }

    @GetMapping("/addPatientForm")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient newPatient = new Patient();
        mav.addObject("patient", newPatient);
        return mav;
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute Patient patient) {
        patientsRepo.save(patient);
        return "redirect:/patlist";
    }

    @GetMapping("/showPatUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long Patient) {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient patient = patientsRepo.findById(Patient).get();
        mav.addObject("patient", patient);
        return mav;
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam Long Patient) {
        patientsRepo.deleteById(Patient);
        return "redirect:/patlist";
    }
}

