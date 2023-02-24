package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.models.Patient;
import com.clinicmgmt.springclinicmgmt.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public Patient saveProduct(Patient patient) {
        return repository.save(patient);
    }
}