package com.example.demo;

import com.example.demo.control.services.ChatroomService;
import com.example.demo.control.services.UserService;
import com.example.demo.model.ChatroomEntity;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ChatroomController {

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value="/chatroom/{id}")
    @ResponseBody
    public ModelAndView chatroom(@PathVariable(name = "id") Long roomId)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chatroom");

        UserEntity currentUser = appContext.getBean(UserService.class).getUserEntityById(0);
        ChatroomEntity chatroomEntity = appContext.getBean(ChatroomService.class).getChatEntityById(roomId);
        if (chatroomEntity.addUser(currentUser)){
            modelAndView.addObject("newUser", true);
        }
        modelAndView.addObject("roomname", chatroomEntity.getName());

        return modelAndView;
    }
}
