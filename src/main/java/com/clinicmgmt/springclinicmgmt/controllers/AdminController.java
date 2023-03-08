package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.dao.AdminRepo;
import com.clinicmgmt.springclinicmgmt.models.Admin;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller @Slf4j
public class AdminController {
    @Autowired
    private AdminRepo aRepo;


    @GetMapping("admin") //http://localhost:8080/admin
    public String showAdmin(){
//        ModelAndView mav = new ModelAndView("admin");
        //Admin admin = aRepo.findById(AdminId);
//        mav.addObject("admin");
        return "admin";
    }

   /* @GetMapping("/addPatientsForm")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patients patients = new Patients();
        mav.addObject("patients", patients);
        return mav;*/

//    @GetMapping("/showUpdatePatient")
//    public ModelAndView showUpdateForm(@RequestParam Long patientId) {
//        ModelAndView mav = new ModelAndView("add-patient-form");
//        Patients patients = pRepo.findById(patientId).get();
//        mav.addObject("patients", patients);
//        return mav;
//    }
    @GetMapping("admindash") //http://localhost:8080/admindash
    public String showadmindash(){
        log.warn("test");
        return "admindash";
    }


}
