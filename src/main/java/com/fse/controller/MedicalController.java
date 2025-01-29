package com.fse.controller;

import com.fse.domain.model.Medical;
import com.fse.service.BaseService;
import com.fse.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical")
public class MedicalController extends BaseController<Medical> {

    @Autowired
    private MedicalService medicalService;

    // Constructor
    public MedicalController(MedicalService medicalService) {
        super(medicalService);
    }

    @Override
    protected String getTableName() {
        return "view_medical";  // Table name for Medical
    }

    @Override
    protected BaseService<Medical> getService() {
        return medicalService;  // MedicalService
    }
}