package com.example.demo.control.repos;

import com.example.demo.model.IdentificationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("identificationRepository")
public interface IdentificationRepository extends CrudRepository<IdentificationEntity, Long> {

}
