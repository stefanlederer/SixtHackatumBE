package com.example.demo.control.repos;

import com.example.demo.entities.ChatroomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ChatroomRepository")
public interface ChatroomRepository extends CrudRepository<ChatroomEntity, Long> {

}
