package com.fse.service;

import com.fse.domain.model.Medical;
import com.fse.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicalService extends BaseService<Medical> {

    @Autowired
    private MedicalRepository medicalRepository;

    @Autowired
    private TraceService traceService;  // Inject the TraceService to log API traces

    @Override
    public List<Medical> fetchAllData() {
        List<Medical> data = medicalRepository.findAllByCreatedAfterMaxTraceDate();
        return data;
    }

    @Override
    public Page<Medical> fetchPaginatedData(Pageable pageable) {
        Page<Medical> data = medicalRepository.findAll(pageable);  // Fetch paginated data from the repository
        return data;
    }

    @Override
    public void traceApi(String methodName, String tableName, LocalDateTime date, Integer pageSize, Integer totalElements) {
      traceService.logTrace(methodName, tableName, date, pageSize, totalElements);  // Log the trace via TraceService
    }
}