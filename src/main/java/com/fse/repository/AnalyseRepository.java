package com.fse.repository;

import com.fse.domain.model.Analyse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnalyseRepository extends JpaRepository<Analyse, Long>  , JpaSpecificationExecutor<Analyse> {
    Page<Analyse> findAll(Pageable pageable);

}

