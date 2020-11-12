package com.tanuj.adminDashboard.controllers;


import com.tanuj.adminDashboard.model.Associate;
import com.tanuj.adminDashboard.model.Company;
import com.tanuj.adminDashboard.service.AssociateServiceIfc;
import com.tanuj.adminDashboard.service.BudgetServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tanuj Kathuria
 * @version 1.0
 */
@CrossOrigin
@SuppressWarnings("unchecked")
@RestController
@RequestMapping
public class MainController {

    @Autowired
    AssociateServiceIfc associateServiceIfc;

    @Autowired
    BudgetServiceIfc budgetServiceIfc;


    @PostMapping("/saveAssociate")
    public ResponseEntity<String> saveAssociateData(@RequestBody List<Associate> associate)
    {
        return associateServiceIfc.saveAssociateData(associate);
    }

    @PutMapping("/appendAssociate")
    public ResponseEntity<String> appendAssociateData(@RequestBody List<Associate> associate)
    {
        return associateServiceIfc.appendAssociateData(associate);
    }


    @PostMapping("/saveBudget")
    public ResponseEntity<String> saveBudgetData(@RequestBody  List<Company> company)
    {
        return budgetServiceIfc.saveBudgetData(company);
    }

    @GetMapping("/getAssociateData")
    public List<Associate> getAssociateData()
    {
        return associateServiceIfc.getAssociateData();
    }

    @GetMapping("/getBudgetData")
    public List<Company> getBudgetData()
    {
        return budgetServiceIfc.getBudgetData();
    }



}
