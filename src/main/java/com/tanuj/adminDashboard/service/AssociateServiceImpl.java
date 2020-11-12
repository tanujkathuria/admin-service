package com.tanuj.adminDashboard.service;

import com.tanuj.adminDashboard.model.Associate;
import com.tanuj.adminDashboard.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssociateServiceImpl implements AssociateServiceIfc {

    @Autowired
    AssociateRepository associateRepository;

    @Override
    public ResponseEntity<String> saveAssociateData(List<Associate> associate) {
        associateRepository.deleteAll();
        List<Associate> associate1 = (List<Associate>)associateRepository.saveAll(associate);
        if(associate1 !=null ){
            return new ResponseEntity(associate1, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Associate> getAssociateData() {
        List<Associate> list = new ArrayList<>();
        associateRepository.findAll().forEach(associate -> {
            list.add(associate);
        });
        return list;
    }

    @Override
    public ResponseEntity<String> appendAssociateData(List<Associate> associate) {
        if(associate.size() < 0){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        associate.forEach(a -> {
            Optional<Associate> associate1 = associateRepository.findById(a.getId());
            if(associate1.isPresent())
            {
                Associate associate2 = associate1.get();
                associate2.setName(a.getName());
                associate2.setAge(a.getAge());
                associate2.setExperience(a.getExperience());
                associateRepository.save(associate2);
            }
            else
            {
                associateRepository.save(a);
            }
        });
        return new ResponseEntity(associate, HttpStatus.OK);
    }


}
