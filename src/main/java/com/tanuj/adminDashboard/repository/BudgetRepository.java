package com.tanuj.adminDashboard.repository;

import com.tanuj.adminDashboard.model.Associate;
import com.tanuj.adminDashboard.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Company,Integer> {
}
