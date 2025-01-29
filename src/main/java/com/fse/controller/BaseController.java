package com.fse.controller;

import com.fse.domain.model.Clinique;
import com.fse.domain.model.Medical;
import com.fse.service.BaseService;
import com.fse.service.CliniqueService;
import com.fse.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;
import com.fse.payload.request.response.PaginatedResponse;

public abstract class BaseController<T> {

    @Autowired
    private MedicalService medicalService;
    @Autowired
    private CliniqueService cliniqueService;

    private final BaseService<T> baseService;  // Reference to the service layer

    // Constructor injection
    public BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    // Fetch all data (non-paginated)
    @GetMapping("/all")
    public ResponseEntity<List<T>> getAllData() {
        List<T> data = baseService.fetchAllData();
        traceApi("getAllData", getTableName(), LocalDateTime.now(), data.size(), data.size());
        return ResponseEntity.ok(data);
    }

    // Fetch data with pagination
    @GetMapping("/paged")
    public ResponseEntity<Page<T>> getPaginatedData(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10));
        Page<T> data = baseService.fetchPaginatedData(pageable);
        traceApi("getPaginatedData", getTableName(), LocalDateTime.now(), pageable.getPageSize(), (int) data.getTotalElements());
        return ResponseEntity.ok(data);
    }

    // Abstract methods to be implemented by concrete controllers
    protected abstract String getTableName();  // Define table name per entity

    // Method to get the service
    protected BaseService<T> getService() {
        return baseService;
    }



    // Fetch data from both services and return as combined response
    @GetMapping("/global")
    public ResponseEntity<PaginatedResponse> getGlobalData() {
        // Fetch data from MedicalService
        List<Medical> medicalData = medicalService.fetchAllData();
        // Fetch data from CliniqueService
        List<Clinique> cliniqueData = cliniqueService.fetchAllData();

        // Trace both calls for medical and clinique data
        traceApi("fetchAllData", "view_medical", LocalDateTime.now(), medicalData.size(), medicalData.size());
        traceApi("fetchAllData", "view_clinique", LocalDateTime.now(), cliniqueData.size(), cliniqueData.size());

        // Create the response object with combined data
        PaginatedResponse response = PaginatedResponse.builder()
                .medicalData(medicalData)
                .cliniqueData(cliniqueData)
                .build();

        return ResponseEntity.ok(response);
    }



    // Method for tracing API calls
    protected void traceApi(String methodName, String tableName, LocalDateTime date, Integer pageSize, Integer totalElements) {
        // Call the service to log the trace
        baseService.traceApi(methodName, tableName, date, pageSize, totalElements);
    }
}