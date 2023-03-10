package org.crystalowusu.springclinicmgmt.dao;

import org.crystalowusu.springclinicmgmt.models.VisitInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitInfoRepo extends JpaRepository<VisitInfo, Long> {
    @Query
    Optional<VisitInfo> findById(Long aLong);
}
