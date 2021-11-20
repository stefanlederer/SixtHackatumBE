package com.example.demo.control.services;

import com.example.demo.entities.UserEntity;

public interface UserService {

    UserEntity save(UserEntity chatroomEntity);

    UserEntity getUserEntityById(long id);

}
