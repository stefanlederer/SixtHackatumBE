package com.example.demo.control.services;

import com.example.demo.control.repos.ChatroomRepository;
import com.example.demo.model.ChatroomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("chatroomService")
public class ChatroomServiceImpl implements ChatroomService {

    @Autowired
    private ChatroomRepository chatroomRepository;

    @Override
    public ChatroomEntity save(ChatroomEntity ChatroomEntity) {
        return chatroomRepository.save(ChatroomEntity);
    }

    @Override
    public ChatroomEntity getChatEntityById(long id) {
        if (chatroomRepository.existsById(id)) {
            return chatroomRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<ChatroomEntity> getAllEntities() {
        List<ChatroomEntity> chatroomEntities = new ArrayList<>();
        Iterable<ChatroomEntity> it = chatroomRepository.findAll();
        for (ChatroomEntity chatroomEntity : it) {
            chatroomEntities.add(chatroomEntity);
        }
        return chatroomEntities;
    }
}
