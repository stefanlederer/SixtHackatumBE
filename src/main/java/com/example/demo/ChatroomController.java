package com.example.demo;

import com.example.demo.control.services.ChatroomService;
import com.example.demo.control.services.UserService;
import com.example.demo.model.ChatroomEntity;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatroomController {

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value="/chatroom/{id}")
    @ResponseBody
    public ModelAndView chatroom(@PathVariable(name = "id") Long roomId)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chatroomtest");

        UserEntity currentUser = appContext.getBean(UserService.class).getUserEntityById(0);
        ChatroomEntity chatroomEntity = appContext.getBean(ChatroomService.class).getChatEntityById(roomId);
        if (chatroomEntity.addUser(currentUser)){
            modelAndView.addObject("newUser", true);
        }
        modelAndView.addObject("roomname", chatroomEntity.getName());

        return modelAndView;
    }

    @MessageMapping("/chatsender")
    @SendTo("/topic/chatreceiver")
    public OutMessage sendout(InMessage message) throws Exception {
        Thread.sleep(500);
        return new OutMessage("[User]: " + HtmlUtils.htmlEscape(message.getName()));
    }


}
