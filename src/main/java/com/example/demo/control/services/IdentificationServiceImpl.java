package com.example.demo.control.services;

import com.example.demo.control.repos.IdentificationRepository;
import com.example.demo.model.IdentificationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("identificationService")
public class IdentificationServiceImpl implements IdentificationService {

    @Autowired
    private IdentificationRepository idRepository;

    @Override
    public IdentificationEntity save(IdentificationEntity identificationEntity) {
        return idRepository.save(identificationEntity);
    }

    @Override
    public IdentificationEntity getUserEntityById(long id) {
        if (idRepository.existsById(id)){
            return idRepository.findById(id).get();
        }
        return null;
    }
}
