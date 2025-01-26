package com.fse.repository;

import com.fse.domain.model.Clinique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CliniqueRepository extends JpaRepository<Clinique, Long> , JpaSpecificationExecutor<Clinique> {
    Page<Clinique> findAll(Pageable pageable);

}

