package com.clinicmgmt.springclinicmgmt.repositories;
import com.clinicmgmt.springclinicmgmt.models.VisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitInfoRepository extends JpaRepository<VisitInfo, Integer> {

}
