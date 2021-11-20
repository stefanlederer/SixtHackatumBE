package com.example.demo.control.services;

import com.example.demo.entities.IdentificationEntity;

public interface IdentificationService {

    IdentificationEntity save(IdentificationEntity identificationEntity);

    IdentificationEntity getUserEntityById(long id);

}
