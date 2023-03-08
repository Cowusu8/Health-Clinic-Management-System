package com.clinicmgmt.springclinicmgmt.dao;

import com.clinicmgmt.springclinicmgmt.models.Doctors;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository @Transactional(rollbackOn = Exception.class)
public interface DoctorsRepo extends JpaRepository<Doctors, Long> {
    Optional<Doctors> findByEmailAllIgnoreCase(String email);

    List<Doctors> findByLastNameAllIgnoreCase(String lastName);

}
