package com.clinicmgmt.springclinicmgmt.services;

import com.clinicmgmt.springclinicmgmt.dao.PatientsRepo;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class PatientService {

    @Autowired
    PatientsRepo patientsRepo;

    public PatientService(PatientsRepo patientsRepo) {
        this.patientsRepo = patientsRepo;
    }

    public void deletepatients(Long id) throws Exception {
        Optional<Patient> wantToDelete = patientsRepo.findById(id);
        if (wantToDelete.isPresent())
            patientsRepo.delete(wantToDelete.get());
        else
            throw new Exception("Can't find the patient" + wantToDelete);
    }
}

