//Required package modules
package org.crystalowusu.springclinicmgmt.controllers;

// Importing required classes

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// Annotation
@Controller
@Slf4j
public class PatientController { // Class

    @Autowired
    private PatientsRepo pRepo;

    @GetMapping({"/patients",})
    public ModelAndView getAllPatients() {
        ModelAndView mav = new ModelAndView("list_patients");
        mav.addObject("patient", pRepo.findAll());
        return mav;
    }

    @GetMapping("/addPatientForm")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add_patient_form");
        Patient patient = new Patient();
        mav.addObject("patient", patient);
        return mav;
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute Patient patient) {
        pRepo.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("add_patient_form");
        Patient patient = pRepo.findById(id).get();
        mav.addObject("patient", patient);
        return mav;
    }

    @GetMapping("/deletePatient")
    public String deleteEmployee(@RequestParam long id) {
        pRepo.deleteById(id);
        return "redirect:/patients";
    }

}


