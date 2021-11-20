package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PoiMatching {

    @RequestMapping(value = "/sendCurrentLocation/{coordinates}", method = RequestMethod.GET)
    @ResponseBody
    public void getCurrentLocation(@PathVariable("coordinates") String coordinates) {
        String[] longLat = coordinates.split("-");
        System.out.println(longLat[0]+longLat[1]);
    }

    private void getAllPois() {

    }
}
