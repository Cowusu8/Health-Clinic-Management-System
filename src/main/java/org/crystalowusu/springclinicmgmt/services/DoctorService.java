package org.crystalowusu.springclinicmgmt.services;

import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.models.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorsRepo repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

}
