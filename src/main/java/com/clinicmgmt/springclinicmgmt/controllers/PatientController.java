package com.clinicmgmt.springclinicmgmt.controllers;

import java.util.*;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import com.clinicmgmt.springclinicmgmt.repositories.PatientsRepository;
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
    private PatientsRepository pRepo;

    @GetMapping({"/showPatients", "/list"})
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("listpatients");
        List<Patients> list = pRepo.findAll();
        mav.addObject("patients", list);
        return mav;
    }

    @GetMapping("/addPatientsForm")
    public ModelAndView addPatientsForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patients newPatient = new Patients();
        mav.addObject("patients", newPatient);
        return mav;
    }

    @PostMapping("/savePatients")
    public String savePatient(@ModelAttribute Patients patients) {
        pRepo.save(patients);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long patientId) {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patients patients = pRepo.findById(patientId).get();
        mav.addObject("patients", patients);
        return mav;
    }

    @GetMapping("/deletePatient")
    public String deletePatient(@RequestParam Long patientId) {
        pRepo.deleteById(patientId);
        return "redirect:/list";
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

    @GetMapping("patient")
    public String showPatientportal() {
        log.warn("test");
        return "patientportal";
    }
}


