package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.models.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorsRepo repository;

    public Doctor saveProduct(Doctor doctor) {
        return repository.save(doctor);
    }

}
