package com.fse.controller;

import com.fse.domain.model.Clinique;
import com.fse.service.BaseService;
import com.fse.service.CliniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/clinique")
public class CliniqueController extends BaseController<Clinique> {

    @Autowired
    private CliniqueService cliniqueService;

    // Constructor
    public CliniqueController(CliniqueService cliniqueService) {
        super(cliniqueService);
    }

    @Override
    protected String getTableName() {
        return "view_clinique";  // Table name for Clinique
    }

    @Override
    protected BaseService<Clinique> getService() {
        return cliniqueService;  // CliniqueService
    }
}