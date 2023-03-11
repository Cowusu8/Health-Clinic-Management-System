package org.crystalowusu.springclinicmgmt.services;

import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientsRepo repo;

    public void savePatient(Patient p) {
//        p.setId(12234);
        repo.save(p);
    }

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> p = repo.findById(id);
        if (p.isPresent()) {
            return p.get();
        }
        return null;
    }

    public void deleteEMp(Long id) {
        repo.deleteById(id);
    }


}