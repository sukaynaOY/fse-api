package com.fse.repository;

import com.fse.domain.model.APITrace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APITraceRepository extends JpaRepository<APITrace, Long> {
}