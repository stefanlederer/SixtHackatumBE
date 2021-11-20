package com.example.demo;

import com.example.demo.control.qrcode.QrCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/order")
    public String order(Model model) {
        return "Homescreen";
    }

    @GetMapping("/getQrCode")
    public String createQrCode(Model model) throws IOException, WriterException {
        String qrCodePath = "src/main/resources/templates/qrCodes";
        int userId = 1234;
        long currentTime = System.currentTimeMillis();
        String name = Integer.toString(userId) + currentTime;
        QrCodeGenerator.createQR(name, qrCodePath + "/" + name + ".png", 200, 200);
        model.addAttribute("name", "/qrCodes/" + name + ".png");
        return "QrCode";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        return "Menu";
    }
}
