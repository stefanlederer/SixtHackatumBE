package com.example.demo;

import com.example.demo.control.services.PoiService;
import com.example.demo.control.services.PoiServiceImpl;
import com.example.demo.model.PoiEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
public class PoiMatching {

    @Autowired
    private ApplicationContext appContext;

    @GetMapping(value = "/sightseeing/{coordinates}")
    @ResponseBody
    public String sightseeing(@PathVariable("coordinates") String coordinates, Model model) {
        String[] longLat = coordinates.split("-");
        System.out.println(longLat[0]+longLat[1]);
        List<PoiEntity> poiEntitiesNearby = matchPoiToCurrentLocation(longLat[0], longLat[1]);
        model.addAttribute("poiEntities", poiEntitiesNearby);
        return "Sightseeing";
    }

    private List<PoiEntity> getAllPois() {
        PoiService poiService = appContext.getBean(PoiService.class);
        Iterable<PoiEntity> poiEntityList = poiService.getAll();
        return StreamSupport.stream(poiEntityList.spliterator(), false)
                        .collect(Collectors.toList());
    }

    private List<PoiEntity> matchPoiToCurrentLocation(String currentLon, String currentLat) {
        int radius = 5;
        List<PoiEntity> poiEntityList = getAllPois();
        List<PoiEntity> poiEntitiesNearby = new ArrayList<PoiEntity>();
        for(PoiEntity poiEntity : poiEntityList) {
            String poiEntityLon = reduceCoordinateRadius(poiEntity.getLon(), radius);
            String currentLonNew = reduceCoordinateRadius(currentLon, radius);
            String poiEntityLat = reduceCoordinateRadius(poiEntity.getLat(), radius);
            String currentLatNew = reduceCoordinateRadius(currentLat, radius);
            if (poiEntityLat.equals(currentLonNew) &&
            poiEntityLon.equals(currentLatNew)) {
                poiEntitiesNearby.add(poiEntity);
            }
        }
        return poiEntitiesNearby;
    }

    private String reduceCoordinateRadius(String coordinate, int factor) {
        String[] splittedCoord = coordinate.split("");
        StringBuilder newCoord = new StringBuilder();
        for (int i = 0; i < splittedCoord.length - factor; i++) {
            newCoord.append(splittedCoord[i]);
        }
        return newCoord.toString();
    }
}
