package com.example.demo.control.services;

import com.example.demo.model.UserEntity;

public interface UserService {

    UserEntity save(UserEntity userEntity);

    UserEntity getUserEntityById(long id);

}
