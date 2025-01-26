package com.fse.service;

import com.fse.domain.model.Analyse;
import com.fse.domain.model.Clinique;
import com.fse.domain.model.Medical;
import com.fse.payload.request.response.PaginatedResponse;
import com.fse.repository.AnalyseRepository;
import com.fse.repository.CliniqueRepository;
import com.fse.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Autowired
    private AnalyseRepository analyseRepository;

    @Autowired
    private CliniqueRepository cliniqueRepository;

    public PaginatedResponse fetchAllData(
            int medicalPage, int medicalSize,
            int analysePage, int analyseSize,
            int cliniquePage, int cliniqueSize,
            String searchQuery) {

        // Fetch paginated and filtered data for each table
        Page<Medical> medicalPageData = medicalRepository.findAll(
                (root, query, criteriaBuilder) -> {
                    if (searchQuery != null && !searchQuery.isEmpty()) {
                        return criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("nomMedicament")), "%" + searchQuery.toLowerCase() + "%")
                        );
                    }
                    return null; // No filtering if searchQuery is empty
                },
                PageRequest.of(medicalPage, medicalSize)
        );

        Page<Analyse> analysePageData = analyseRepository.findAll(
                (root, query, criteriaBuilder) -> {
                    if (searchQuery != null && !searchQuery.isEmpty()) {
                        return criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("nomAnalyse")), "%" + searchQuery.toLowerCase() + "%")
                        );
                    }
                    return null; // No filtering if searchQuery is empty
                },
                PageRequest.of(analysePage, analyseSize)
        );

        Page<Clinique> cliniquePageData = cliniqueRepository.findAll(
                (root, query, criteriaBuilder) -> {
                    if (searchQuery != null && !searchQuery.isEmpty()) {
                        return criteriaBuilder.or(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get("nomClinique")), "%" + searchQuery.toLowerCase() + "%")
                        );
                    }
                    return null; // No filtering if searchQuery is empty
                },
                PageRequest.of(cliniquePage, cliniqueSize)
        );

        // Get total counts for each list (filtered if searchQuery is provided)
        long medicalTotalCount = medicalPageData.getTotalElements();
        long analyseTotalCount = analysePageData.getTotalElements();
        long cliniqueTotalCount = cliniquePageData.getTotalElements();

        // Populate response
        PaginatedResponse response = new PaginatedResponse();
        response.setMedicalList(medicalPageData.getContent());
        response.setAnalyseList(analysePageData.getContent());
        response.setCliniqueList(cliniquePageData.getContent());

        // Set pagination and total counts
        response.setMedicalTotalCount(medicalTotalCount);
        response.setAnalyseTotalCount(analyseTotalCount);
        response.setCliniqueTotalCount(cliniqueTotalCount);

        response.setMedicalPage(medicalPage);
        response.setAnalysePage(analysePage);
        response.setCliniquePage(cliniquePage);

        response.setMedicalTotalPages(medicalPageData.getTotalPages());
        response.setAnalyseTotalPages(analysePageData.getTotalPages());
        response.setCliniqueTotalPages(cliniquePageData.getTotalPages());

        return response;
    }

    public List<Medical> fetchAllMedicalData() {
        return medicalRepository.findAll();
    }

    public List<Analyse> fetchAllAnalyseData() {
        return analyseRepository.findAll();
    }

    public List<Clinique> fetchAllCliniqueData() {
        return cliniqueRepository.findAll();
    }
}
