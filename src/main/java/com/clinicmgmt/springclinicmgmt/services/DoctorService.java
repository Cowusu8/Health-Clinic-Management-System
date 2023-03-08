package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.models.Doctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorsRepo repository;

    public Doctors saveProduct(Doctors doctors) {
        return repository.save(doctors);
    }

}
