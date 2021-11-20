package com.example.demo.control.services;

import com.example.demo.model.ChatroomEntity;

import java.util.List;

public interface ChatroomService {

    ChatroomEntity save(ChatroomEntity ChatroomEntity);

    ChatroomEntity getChatEntityById(long id);

    List<ChatroomEntity> getAllEntities();

}
