package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.models.Patients;
import com.clinicmgmt.springclinicmgmt.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientsRepository repository;

    public Patients saveProduct(Patients patients) {
        return repository.save(patients);
    }
}