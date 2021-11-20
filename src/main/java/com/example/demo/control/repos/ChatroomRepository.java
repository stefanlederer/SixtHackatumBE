package com.example.demo.control.repos;

import com.example.demo.model.ChatroomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("chatroomRepository")
public interface ChatroomRepository extends CrudRepository<ChatroomEntity, Long> {

}
