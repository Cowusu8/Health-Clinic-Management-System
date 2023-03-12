//Required package modules
package org.crystalowusu.springclinicmgmt.services;

// Importing required classes
import org.crystalowusu.springclinicmgmt.dao.PatientsRepo;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PatientService { // Class

    @Autowired
    private PatientsRepo pRepo;

    // Save operation
    public Patient savePatient(Patient patient)
    {
        return pRepo.save(patient);
    }

    // Read operation
    public List<Patient> fetchPatientList()
    {
        return (List<Patient>)
                pRepo.findAll();
    }

    // Update operation
    public Patient
    updateDoctor(Patient patient,
                 Long Id)
    {

        Patient pat
                = pRepo.findById(Id)
                .get();
        return pRepo.save(pat);
    }

    // Delete operation
    public void deletePatientById(Long Id)
    {
        pRepo.deleteById(Id);
    }

}