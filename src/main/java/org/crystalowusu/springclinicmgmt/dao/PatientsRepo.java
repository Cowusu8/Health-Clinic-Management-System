package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PatientsRepo extends JpaRepository<Patient, Long> {
    @Query
    Optional<Patient> findByEmail(String email);

    @Query
    Optional<Patient> findByGender(String gender);

   Optional<Patient> findById(long id);

}
