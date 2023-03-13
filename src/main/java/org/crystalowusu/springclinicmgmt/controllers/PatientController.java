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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Annotation
@Controller
@Slf4j
public class PatientController { // Class

    @Autowired
    private PatientsRepo pRepo;

    // Read operation
    @GetMapping("/patients")
    public String showPatientList(Model model) {
        model.addAttribute("patients", pRepo.findAll());
        return "list_patients";
    }

    @GetMapping("/addPatientsForm")
    public String showSignUpForm(Patient patient) {
        return "add_patient_form";
    }

    // Save operation
    @PostMapping("/addpatient")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add_patient_form";

        }
        pRepo.save(patient);
        return "redirect:/patients";
    }

    // Save operation
    @PostMapping("/updatePatient/{id}")
    public ModelAndView updatePatient(@RequestParam("patientId") long id) {
        Patient patient = pRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        ModelAndView mav = new ModelAndView("add-patient-form");
        mav.addObject("patient", patient);
        return mav;
    }


//    @GetMapping("/showUpdatePatient/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        Patient patient = pRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
//
//        model.addAttribute("patient", patient);
//        return "add_patient_form";
//    }

    //Delete Operation
    @GetMapping("/deletePatient") //deleting a patient
    public String deletePatient(@PathVariable("id") long id, Model model) {
        Patient patient = pRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        pRepo.delete(patient);
        return "redirect:/patients";
    }


}


