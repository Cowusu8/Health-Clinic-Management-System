package org.crystalowusu.springclinicmgmt.dao;


import org.crystalowusu.springclinicmgmt.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepoI extends JpaRepository<AuthGroup, Integer> {
    List<AuthGroup> findByEmail(String email);
}