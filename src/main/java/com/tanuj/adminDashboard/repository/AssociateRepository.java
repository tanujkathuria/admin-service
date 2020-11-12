package com.tanuj.adminDashboard.repository;

import com.tanuj.adminDashboard.model.Associate;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@Repository
public interface AssociateRepository extends CrudRepository<Associate,Integer> {

    public List<Associate> findByName(String associateName);

}
