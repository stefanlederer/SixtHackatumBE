package com.example.demo;

import com.example.demo.control.qrcode.QrCodeGenerator;
import com.example.demo.control.services.ChatroomService;
import com.example.demo.model.ChatroomEntity;
import com.google.zxing.WriterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping("/order")
    public String order(Model model) {
        return "Homescreen";
    }

    @GetMapping("/getQrCode")
    public String createQrCode(Model model) throws IOException, WriterException {
        //ToDo: change this!
        String qrCodePath = "src/main/resources/static/qrCodes";
        int userId = 1234;
        long currentTime = System.currentTimeMillis();
        String name = Integer.toString(userId) + currentTime;
        QrCodeGenerator.createQR(name, qrCodePath + "/" + name + ".png", 200, 200);
        model.addAttribute("name", "qrCodes/" + name + ".png");
        return "QrCode";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        return "Menu";
    }
    

    @GetMapping("/chatroomOverview")
    public String chatroomOverview(Model model) {
        List<ChatroomEntity> array = appContext.getBean(ChatroomService.class).getAllEntities();

        model.addAttribute("rooms", array);
        return "ChatroomOverview";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }
}
