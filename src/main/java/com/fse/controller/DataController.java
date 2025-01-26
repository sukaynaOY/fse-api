package com.fse.controller;

import com.fse.domain.model.Analyse;
import com.fse.domain.model.Clinique;
import com.fse.domain.model.Medical;
import com.fse.payload.request.response.PaginatedResponse;
import com.fse.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/fetch")
    public PaginatedResponse fetchAllData(
            @RequestParam(defaultValue = "0") int medicalPage,
            @RequestParam(defaultValue = "10") int medicalSize,
            @RequestParam(defaultValue = "0") int analysePage,
            @RequestParam(defaultValue = "10") int analyseSize,
            @RequestParam(defaultValue = "0") int cliniquePage,
            @RequestParam(defaultValue = "10") int cliniqueSize,
            @RequestParam(required = false) String searchQuery) {

        return dataService.fetchAllData(medicalPage, medicalSize, analysePage, analyseSize, cliniquePage, cliniqueSize, searchQuery);
    }
    @GetMapping("/fetchAllmedical")
    public List<Medical> fetchAllMedicalData() {
        return dataService.fetchAllMedicalData();
    }

    @GetMapping("/fetchAllanalyse")
    public List<Analyse> fetchAllAnalyseData() {
        return dataService.fetchAllAnalyseData();
    }

    @GetMapping("/fetchAllclinique")
    public List<Clinique> fetchAllCliniqueData() {
        return dataService.fetchAllCliniqueData();
    }
}
