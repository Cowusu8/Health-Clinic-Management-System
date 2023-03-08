package com.clinicmgmt.springclinicmgmt.dao;

import com.clinicmgmt.springclinicmgmt.models.Doctors;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctors,Long> {
    @Query("SELECT D.patients FROM Doctors D")
    List<Patients> findDoctorPatients(int id);

    Optional<Doctors> findByEmail(String email);
}