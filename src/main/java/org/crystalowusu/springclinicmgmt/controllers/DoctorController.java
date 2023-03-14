//Required package modules
package org.crystalowusu.springclinicmgmt.controllers;

// Importing required classes
import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


// Annotations
@Controller  @Slf4j
public class DoctorController { //Class

    @Autowired
    private DoctorsRepo dRepo;

    @GetMapping({"/doctors",})
    public ModelAndView getAllDoctors() {
        ModelAndView mav = new ModelAndView("list_doctors");
        mav.addObject("doctor", dRepo.findAll());
        return mav;
    }

    @GetMapping("/addDoctorForm")
    public ModelAndView addDoctorForm() {
        ModelAndView mav = new ModelAndView("add_doctor_form");
        Doctor doctor = new Doctor();
        mav.addObject("doctor", doctor);
        return mav;
    }

    @PostMapping("/saveDoctor")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        dRepo.save(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/showUpdateDocForm")
    public ModelAndView showDocUpdateForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("add_doctor_form");
        Doctor doctor = dRepo.findById(id).get();
        mav.addObject("doctor", doctor);
        return mav;
    }

    @GetMapping("/deleteDoctor")
    public String deleteDoctor(@RequestParam long id) {
        dRepo.deleteById(id);
        return "redirect:/doctors";
    }

}



