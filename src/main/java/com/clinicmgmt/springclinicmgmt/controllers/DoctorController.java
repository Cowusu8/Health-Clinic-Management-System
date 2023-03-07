package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.models.Doctors;
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

    @GetMapping("docs") //http://localhost:8080/docs
    public String showdoc(){
        log.warn("test");
        return "doc";
    }
    @GetMapping("docportal") //http://localhost:8080/docportal
    public String showdoctorsportal(){
        log.warn("test");
        return "doctorsportal";
    }

    @GetMapping("docdash") //http://localhost:8080/docdash
    public String showdocdash(){
        log.warn("test");
        return "docdash";
    }

    @GetMapping({"/showDoctors", "/doctors"}) //http://localhost:8080/doctors
    public ModelAndView showDoctors() {
        ModelAndView mav = new ModelAndView("listdoctors");
        List<Doctors> doctors = dRepo.findAll();
        mav.addObject("doctors", doctors);
        return mav;
    }

    @GetMapping("/addDoctorsForm")
    public ModelAndView addDoctorsForm() {
        ModelAndView mav = new ModelAndView("add-doctor-form");
        Doctors newDoctor = new Doctors();
        mav.addObject("doctors", newDoctor);
        return mav;
    }

    @PostMapping("/saveDoctors")
    public String saveDoctor(@ModelAttribute Doctors doctors) {
        dRepo.save(doctors);
        return "redirect:/doctors";
    }

    @GetMapping("/showUpdateDocForm")
    public ModelAndView showUpdateForm(@RequestParam Long doctorId) {
        ModelAndView mav = new ModelAndView("add-doctor-form");
        Doctors doctors = dRepo.findById(doctorId).get();
        mav.addObject("doctors", doctors);
        return mav;
    }

    @GetMapping("/deleteDoctor")
    public String deleteDoctor(@RequestParam Long doctorId) {
        dRepo.deleteById(doctorId);
        return "redirect:/doctors";
    }

}
