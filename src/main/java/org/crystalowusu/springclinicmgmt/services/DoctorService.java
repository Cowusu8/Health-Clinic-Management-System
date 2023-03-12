//Required package modules
package org.crystalowusu.springclinicmgmt.services;

// Importing required classes
import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DoctorService { // Class

    @Autowired
    DoctorsRepo dRepo;

    // Save operation
    public Doctor saveDepartment(Doctor doctor)
    {
        return dRepo.save(doctor);
    }

    // Read operation
    public List<Doctor> fetchDoctorList()
    {
        return (List<Doctor>)
                dRepo.findAll();
    }

    // Update operation
    public Doctor
    updateDoctor(Doctor doctor,
                     Long Id)
    {

        Doctor doc
                = dRepo.findById(Id)
                .get();
        return dRepo.save(doc);
    }

    // Delete operation
    public void deleteDoctorById(Long Id)
    {
        dRepo.deleteById(Id);
    }
}

