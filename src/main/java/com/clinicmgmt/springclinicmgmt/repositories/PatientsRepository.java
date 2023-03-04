package com.clinicmgmt.springclinicmgmt.repositories;
import com.clinicmgmt.springclinicmgmt.models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

}
