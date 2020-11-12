package com.tanuj.adminDashboard.service;


import com.tanuj.adminDashboard.model.Associate;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Tanuj Kathuria
 * @version 1.0
 */
public interface AssociateServiceIfc {
    ResponseEntity<String> saveAssociateData(List<Associate> associate);
    public List<Associate> getAssociateData();
    ResponseEntity<String> appendAssociateData(List<Associate> associate);
}
