package com.tanuj.adminDashboard.service;

import com.tanuj.adminDashboard.model.Associate;
import com.tanuj.adminDashboard.model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BudgetServiceIfc {
    ResponseEntity<String> saveBudgetData(List<Company> company);
    public List<Company> getBudgetData();
}
