package com.fse.service;

import com.fse.domain.model.Clinique;
import com.fse.domain.model.Medical;
import com.fse.repository.CliniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CliniqueService extends BaseService<Clinique> {

    @Autowired
    private CliniqueRepository cliniqueRepository;
    @Autowired
    private TraceService traceService;  // Inject the TraceService to log API traces

    @Override
    public List<Clinique> fetchAllData() {
        List<Clinique> data = cliniqueRepository.findAllByCreatedAfterMaxTraceDate();
        return data; // Fetch all data from the repository
    }

    @Override
    public Page<Clinique> fetchPaginatedData(Pageable pageable) {
        Page<Clinique> data = cliniqueRepository.findAll(pageable);  // Fetch paginated data from the repository
        return data;
    }
    @Override
    public void traceApi(String methodName, String tableName, LocalDateTime date, Integer pageSize, Integer totalElements) {
        // Custom logging for tracing the API calls
       traceService.logTrace(methodName, tableName, date, pageSize, totalElements);  // Log the trace via TraceService
    }
}