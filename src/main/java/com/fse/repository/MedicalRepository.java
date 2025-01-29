package com.fse.repository;

import com.fse.domain.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {

    @Query("SELECT c FROM Medical c WHERE c.created > (SELECT MAX(t.dated) FROM APITrace t WHERE t.tableName = 'view_medical')")
    List<Medical> findAllByCreatedAfterMaxTraceDate();
}