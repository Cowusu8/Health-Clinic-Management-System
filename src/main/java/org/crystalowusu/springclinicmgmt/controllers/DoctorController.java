//Required package modules
package org.crystalowusu.springclinicmgmt.controllers;

// Importing required classes
import jakarta.validation.Valid;
import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Annotations
@Controller  @Slf4j
public class DoctorController { //Class

        @Autowired
        private DoctorsRepo dRepo;

        @GetMapping("/doctors")
        public ModelAndView showPatients() {
            ModelAndView mav = new ModelAndView("listdoctors");
            List<Doctor> doctor = dRepo.findAll();
            mav.addObject("doctors", doctor);
            return mav;
        }

        @GetMapping("/addDoctorsForm")
        public ModelAndView addPatientForm() {
            ModelAndView mav = new ModelAndView("add-patient-form");
            Doctor doctor = new Doctor();
            mav.addObject("doctor", doctor);
            return mav;
        }

        @PostMapping("/saveDoctors")
        public String savePatient(@ModelAttribute Doctor doctor) {
            System.out.println("login..."+doctor);
            dRepo.save(doctor);
            return "redirect:/doctors";
        }

        @GetMapping("/showUpdateDoctor")
        public ModelAndView showUpdateForm(@RequestParam Long id) {
            ModelAndView mav = new ModelAndView("add-doctor-form");
            Doctor doctor = dRepo.findById(id).get();
            mav.addObject("doctor", doctor);
            return mav;
        }

        @GetMapping("/deleteDoctor")
        public String deletePatients(@RequestParam Long id) {
            dRepo.deleteById(id);
            return "redirect:/doctor";
        }


//    @GetMapping("patient")
//    public String showPatientportal() {
//        log.warn("test");
//        return "listpatients";
//    }


    }
