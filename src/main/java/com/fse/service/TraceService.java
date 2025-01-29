package com.fse.service;

import com.fse.domain.model.APITrace;
import com.fse.repository.APITraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TraceService {

    @Autowired
    private APITraceRepository apiTraceRepository;

    public void logTrace(String method, String tableName, LocalDateTime date, Integer pageSize, Integer totalElements) {
        // Use the builder to create an APITrace object
        APITrace trace = APITrace.builder()
                .method(method)
                .tableName(tableName)
                .dated(date)
                .pageSize(pageSize)
                .totalElements(totalElements)
                .build();

        // Save the trace to the database
        apiTraceRepository.save(trace);
    }
}