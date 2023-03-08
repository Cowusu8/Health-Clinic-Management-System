package com.clinicmgmt.springclinicmgmt.dao;

import com.clinicmgmt.springclinicmgmt.models.Doctor;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctor,Long> {
    @Query("SELECT D.patients FROM Doctor D")
    List<Patient> findDoctorPatients(int id);

    Optional<Doctor> findByEmail(String email);
}