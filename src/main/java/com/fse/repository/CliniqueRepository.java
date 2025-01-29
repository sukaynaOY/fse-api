package com.fse.repository;

import com.fse.domain.model.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CliniqueRepository extends JpaRepository<Clinique, Long> {


    @Query("SELECT c FROM Clinique c WHERE c.created > (SELECT MAX(t.dated) FROM APITrace t WHERE t.tableName = 'view_clinique')")
    List<Clinique> findAllByCreatedAfterMaxTraceDate();
}