package com.clinicmgmt.springclinicmgmt.controllers;
import java.util.*;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import com.clinicmgmt.springclinicmgmt.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository pRepo;

    @GetMapping({"/showPatients","/", "/list"})
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("list-patient");
        List<Patient> list= pRepo.findAll();
        mav.addObject("patient", list);
        return mav;
    }
}
