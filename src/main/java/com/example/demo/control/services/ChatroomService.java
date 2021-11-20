package com.example.demo.control.services;

import com.example.demo.model.ChatroomEntity;

public interface ChatroomService {

    ChatroomEntity save(ChatroomEntity ChatroomEntity);

    ChatroomEntity getUserEntityById(long id);

}
