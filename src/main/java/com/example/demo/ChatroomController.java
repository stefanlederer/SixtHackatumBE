package com.example.demo;

import com.example.demo.control.chat.InMessage;
import com.example.demo.control.chat.OutMessage;
import com.example.demo.control.services.ChatroomService;
import com.example.demo.control.services.UserService;
import com.example.demo.model.ChatroomEntity;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatroomController {

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value="/chatroom/{id}")
    @ResponseBody
    public ModelAndView chatroom(@PathVariable(name = "id") Long roomId) {
        ModelAndView modelAndView = new ModelAndView("forward:/chatroom.html");

        ChatroomEntity chatroomEntity = appContext.getBean(ChatroomService.class).getChatEntityById(roomId);
        modelAndView.addObject("roomname", "You are talking in " + chatroomEntity.getName());

        return modelAndView;
    }

    @MessageMapping("/chatsender")
    @SendTo("/topic/chatreceiver")
    public OutMessage sendout(InMessage message) throws Exception {
        Thread.sleep(500);
        return new OutMessage(HtmlUtils.htmlEscape(message.getName()));
    }


}
