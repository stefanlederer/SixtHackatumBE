package com.example.demo.control.services;

import com.example.demo.control.repos.ChatroomRepository;
import com.example.demo.entities.ChatroomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("ChatroomService")
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    private ChatroomRepository chatroomRepository;

    @Override
    public ChatroomEntity save(ChatroomEntity ChatroomEntity) {
        return chatroomRepository.save(ChatroomEntity);
    }

    @Override
    public ChatroomEntity getUserEntityById(long id) {
        if (chatroomRepository.existsById(id)){
            return chatroomRepository.findById(id).get();
        }
        return null;
    }
}
