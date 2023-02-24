package com.clinicmgmt.springclinicmgmt.repositories;
import com.clinicmgmt.springclinicmgmt.models.Visit_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Visit_InfoRepository extends JpaRepository<Visit_Info, Integer> {

}
