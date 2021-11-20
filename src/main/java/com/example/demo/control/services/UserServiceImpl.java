package com.example.demo.control.services;

import com.example.demo.control.repos.UserRepository;
import com.example.demo.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity chatroomEntity) {
        return userRepository.save(chatroomEntity);
    }

    @Override
    public UserEntity getUserEntityById(long id) {
        if (userRepository.existsById(id)){
            return userRepository.findById(id).get();
        }
        return null;
    }
}
