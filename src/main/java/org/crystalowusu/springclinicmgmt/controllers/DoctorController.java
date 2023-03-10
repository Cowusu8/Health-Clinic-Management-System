package org.crystalowusu.springclinicmgmt.controllers;

import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.models.Patient;
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
    private PatientsRepo patientsRepo;

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

    @GetMapping("/doc-dash") //http://localhost:8080/docdash
    public String showdocdash(){
        log.warn("test");
        return "docdash";
    }

  /*  @GetMapping("/adddoc") //http://localhost:8080/docs
    public String showemdoc(){
        log.warn("test");
        return "add-doctor-form";
    }*/

    @GetMapping({"/add-doctors", "/add-doctor"})
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
        return "redirect:/add-doctor";
    }

    @GetMapping("/update-doc-form")
    public ModelAndView showUpdateForm(@RequestParam Long doctorId) {
        ModelAndView mav = new ModelAndView("add-doctor-form");
        Doctor doctor = dRepo.findById(doctorId).get();
        mav.addObject("doctor", doctor);
        return mav;
    }

    @GetMapping({"/add-patients", "/add-patient"})
    public ModelAndView showPatients() {
        ModelAndView mav = new ModelAndView("listpatients");
        List<Patient> patients = patientsRepo.findAll();
        mav.addObject("patients", patients);
        return mav;
    }

    @GetMapping("/add-patient-form")
    public ModelAndView addPatientForm() {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient newPatient = new Patient();
        mav.addObject("patients", newPatient);
        return mav;
    }

    @PostMapping("/save-patient")
    public String savePatient(@ModelAttribute Patient patient) {
        patientsRepo.save(patient);
        return "redirect:/add-patient";
    }

    @PostMapping("/save-newpatient")
    public String savenewPatient(@ModelAttribute Patient patient) {
        patientsRepo.save(patient);
        return "redirect:/add-patient";
    }

    @GetMapping("/update-patient-form")
    public ModelAndView UpdatepatientForm(@RequestParam Long patientId) {
        ModelAndView mav = new ModelAndView("add-patient-form");
        Patient patient = patientsRepo.findById(patientId).get();
        mav.addObject("patient", patient);
        return mav;
    }

    @GetMapping("/delete-patient")
    public String deletePatient(@RequestParam Long patientId) {
        dRepo.deleteById(patientId);
        return "redirect:/listpatients";
    }





  /*  @GetMapping("/delete-doctor")
    public String deleteDoctor(@RequestParam Long doctorId) {
        dRepo.deleteById(doctorId);
        return "redirect:/doctors";
    }*/

}
