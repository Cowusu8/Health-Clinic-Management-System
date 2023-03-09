package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepo extends JpaRepository<Patient, Long> {

}
