package com.example.demo.control.services;

import com.example.demo.control.repos.PoiRepository;
import com.example.demo.model.PoiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("poiService")
public class PoiServiceImpl implements PoiService {

    @Autowired
    private PoiRepository poiRepository;

    @Override
    public PoiEntity save(PoiEntity poiEntity) {
        return poiRepository.save(poiEntity);
    }

    @Override
    public PoiEntity getPoiEntityById(long id) {
        return poiRepository.findById(id).get();
    }

    @Override
    public Iterable<PoiEntity> getAll() {
        return poiRepository.findAll();
    }
}
