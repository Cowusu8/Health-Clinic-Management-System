package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller  @Slf4j
public class DoctorController {

    @Autowired
    private DoctorsRepo dRepo;

    @GetMapping("/doctors") //http://localhost:8080/docs
    public String showdoc(){
        log.warn("test");
        return "doc";
    }
    @GetMapping("/doctor-portal") //http://localhost:8080/docportal
    public String showdoctorsportal(){
        log.warn("test");
        return "doctorsportal";
    }

    @GetMapping("/doc-dashboard") //http://localhost:8080/docdash
    public String showdocdash(){
        log.warn("test");
        return "docdash";
    }

    @GetMapping({"/show-doctors", "/em-doctor"}) //http://localhost:8080//em-doctor"
    public ModelAndView showDoctors() {
        ModelAndView mav = new ModelAndView("listdoctors");
        List<Doctor> doctors = dRepo.findAll();
        mav.addObject("doctors", doctors);
        return mav;
    }

    @GetMapping("/add-doctor-form")
    public ModelAndView addDoctorsForm() {
        ModelAndView mav = new ModelAndView("add-doctor-form");
        Doctor newDoctor = new Doctor();
        mav.addObject("doctors", newDoctor);
        return mav;
    }

    @PostMapping("/save-doctors")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        dRepo.save(doctor);
        return "redirect:/doctor";
    }

    @GetMapping("/show-update-doc-form")
    public ModelAndView showUpdateForm(@RequestParam Long doctorId) {
        ModelAndView mav = new ModelAndView("add-doctor-form");
        Doctor doctor = dRepo.findById(doctorId).get();
        mav.addObject("doctor", doctor);
        return mav;
    }

    @GetMapping("/delete-doctor")
    public String deleteDoctor(@RequestParam Long doctorId) {
        dRepo.deleteById(doctorId);
        return "redirect:/doctors";
    }

}
