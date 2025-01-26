package com.fse.repository;

import com.fse.domain.model.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicalRepository extends JpaRepository<Medical, Long>, JpaSpecificationExecutor<Medical> {
    Page<Medical> findAll(Pageable pageable);

}


