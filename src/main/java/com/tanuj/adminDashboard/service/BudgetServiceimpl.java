package com.tanuj.adminDashboard.service;

import com.tanuj.adminDashboard.model.Associate;
import com.tanuj.adminDashboard.model.Company;
import com.tanuj.adminDashboard.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceimpl  implements BudgetServiceIfc{

    @Autowired
    BudgetRepository budgetRepository;

    @Override
    public ResponseEntity<String> saveBudgetData(List<Company> company) {
        budgetRepository.deleteAll();
        List<Company> company1 = (List<Company>)budgetRepository.saveAll(company);
        if(company1 !=null){
            return new ResponseEntity(company1, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Company> getBudgetData() {
        List<Company> list = new ArrayList<>();
        budgetRepository.findAll().forEach(company -> {
            list.add(company);
        });
        return list;
    }
}
