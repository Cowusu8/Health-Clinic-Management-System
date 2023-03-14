package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.Doctor;
import org.crystalowusu.springclinicmgmt.models.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctor, Long> {

    @Query
    Optional<Doctor> findByEmail(String email);

    Optional<Doctor> findById(long id);


    long deleteDoctorById(long id);

    @Override
    List<Doctor> findAll(Sort sort);
}