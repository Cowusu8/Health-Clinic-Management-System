package com.clinicmgmt.springclinicmgmt.repositories;

import com.clinicmgmt.springclinicmgmt.models.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {

}