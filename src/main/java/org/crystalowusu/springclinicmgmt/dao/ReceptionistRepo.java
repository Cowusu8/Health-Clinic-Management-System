package org.crystalowusu.springclinicmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionistRepo extends JpaRepository<Receptionist, Long> {
    List<Receptionist> findByEmail(String email);

    Receptionist findByUsername(String username);

    List<Receptionist> findByEmailAllIgnoreCase(String username);
}