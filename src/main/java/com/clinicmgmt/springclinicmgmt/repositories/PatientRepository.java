package com.clinicmgmt.springclinicmgmt.repositories;
import com.clinicmgmt.springclinicmgmt.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
