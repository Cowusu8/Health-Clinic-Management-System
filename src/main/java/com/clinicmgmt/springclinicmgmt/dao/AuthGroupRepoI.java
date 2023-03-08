package com.clinicmgmt.springclinicmgmt.dao;

import com.clinicmgmt.springclinicmgmt.models.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepoI extends JpaRepository<AuthGroup,Integer> {

    List<AuthGroup> findByUsername(String Username);

}