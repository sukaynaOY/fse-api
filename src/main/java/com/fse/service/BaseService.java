package com.fse.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public abstract class BaseService<T> {

    public abstract List<T> fetchAllData();  // Fetch all data from the repository
    public abstract Page<T> fetchPaginatedData(Pageable pageable);  // Fetch paginated data from the repository
    public abstract void traceApi(String methodName, String tableName, LocalDateTime date, Integer pageSize, Integer totalElements);  // Trace the API call
}