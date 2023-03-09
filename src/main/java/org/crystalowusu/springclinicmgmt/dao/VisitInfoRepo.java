package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.VisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitInfoRepo extends JpaRepository<VisitInfo, Long> {

}
