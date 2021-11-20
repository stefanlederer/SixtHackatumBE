package com.example.demo.control.repos;

import com.example.demo.model.ChatroomEntity;
import com.example.demo.model.PoiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("poiRepository")
public interface PoiRepository  extends CrudRepository<PoiEntity, Long> {
}
