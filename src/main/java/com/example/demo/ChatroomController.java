package com.example.demo;

import com.example.demo.control.services.ChatroomService;
import com.example.demo.control.services.UserService;
import com.example.demo.model.ChatroomEntity;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatroomController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping("/chatroomOverview")
    public String chatroomOverview(Model model) {
        List<ChatroomEntity> array = appContext.getBean(ChatroomService.class).getAllEntities();

        model.addAttribute("rooms", array);
        return "ChatroomOverview";
    }

    @GetMapping(value="/chatroom/{id}")
    @ResponseBody
    public String chatroom(@PathVariable(name = "id") Long roomId, Model model)
    {
        UserEntity currentUser = appContext.getBean(UserService.class).getUserEntityById(0);
        ChatroomEntity chatroomEntity = appContext.getBean(ChatroomService.class).getChatEntityById(roomId);
        if (chatroomEntity.addUser(currentUser)){
            model.addAttribute("newUser", true);
        }
        model.addAttribute("room", chatroomEntity);
        return "Chatroom " + chatroomEntity.getName();
    }
}
