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

// Annotations
@Controller  @Slf4j
public class DoctorController { //Class

    @Autowired
    private DoctorsRepo dRepo;

    // Read operation
    @GetMapping("/doctors")
    public String showDoctorList(Model model) {
        model.addAttribute("doctors", dRepo.findAll());
        return "list_doctors";
    }

    @GetMapping("/addDoctorsForm")
    public String showDocSignUpForm(Doctor doctor) {
        return "add_doctor_form";
    }

    // Save operation
    @PostMapping("/add-doctor")
    public String addDoctor(@Valid Doctor doctor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add_doctor_form";
        }

        dRepo.save(doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/saveDoctors/{id}")
    public String updateDoctor(@PathVariable("id") long id, @Valid Doctor doctor,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            doctor.setId(id);
            return "add_doctor_form";
        }dRepo.save(doctor);
        return "redirect:/doctors";
    }
    @GetMapping("/showUpdateDoctor/{id}")
    public String showUpdateDocForm(@PathVariable("id") long id, Model model) {
        Doctor doctor = dRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id:" + id));

        model.addAttribute("doctor", doctor);
        return "add_doctors_form";
    }

    // Update operation
    @PutMapping("/doctor/{id}")

//    public Doctor
//    updateDoctor(@RequestBody Doctor doctor,
//                     @PathVariable("id") Long Id)
//    {
//        return DoctorService.updateDoctor(
//                doctor, Id);
//    }


    // Delete Operation
    @DeleteMapping("/deleteDoctor/{id}")

    public String deleteDoctorById(@PathVariable("id")
                                       Long Id)
    {
        dRepo.deleteDoctorById(
                Id);
        return "Deleted Successfully";
    }


}