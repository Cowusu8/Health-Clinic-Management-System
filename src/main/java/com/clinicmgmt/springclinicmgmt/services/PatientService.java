package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.dao.PatientsRepo;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientsRepo repository;

    public Patients saveProduct(Patients patients) {
        return repository.save(patients);
    }

}