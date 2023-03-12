package org.crystalowusu.springclinicmgmt.dao;

import jakarta.transaction.Transactional;
import org.crystalowusu.springclinicmgmt.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @Transactional(rollbackOn = Exception.class)
public interface AdminRepoI extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmailAllIgnoreCase(String email);
}
