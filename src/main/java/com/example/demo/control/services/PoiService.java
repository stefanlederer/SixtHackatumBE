package com.example.demo.control.services;

import com.example.demo.model.PoiEntity;

public interface PoiService {

    PoiEntity save(PoiEntity poiEntity);

    PoiEntity getPoiEntityById(long id);

    Iterable<PoiEntity> getAll();
}
