package com.example.demo;

import com.example.demo.control.services.PoiService;
import com.example.demo.control.services.PoiServiceImpl;
import com.example.demo.model.PoiEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
public class PoiMatching {

    @Autowired
    private ApplicationContext appContext;

    @RequestMapping(value = "/sightseeing/{coordinates}")
    @ResponseBody
    public ModelAndView sightseeing(@PathVariable("coordinates") String coordinates, Model model) {
        ModelAndView modelAndView = new ModelAndView("Sightseeing");
        modelAndView.addAllObjects(model.asMap());
        String[] longLat = coordinates.split("-");

        List<PoiEntity> poiEntitiesNearby = matchPoiToCurrentLocation(longLat[0], longLat[1]);
        modelAndView.addObject("poiEntities", poiEntitiesNearby);
        return modelAndView;
    }

    private List<PoiEntity> getAllPois() {
        PoiService poiService = appContext.getBean(PoiService.class);
        Iterable<PoiEntity> poiEntityList = poiService.getAll();
        return StreamSupport.stream(poiEntityList.spliterator(), false)
                        .collect(Collectors.toList());
    }

    private List<PoiEntity> matchPoiToCurrentLocation(String currentLat, String currentLon) {
        int radius = 5;
        List<PoiEntity> poiEntityList = getAllPois();
        List<PoiEntity> poiEntitiesNearby = new ArrayList<PoiEntity>();
        for(PoiEntity poiEntity : poiEntityList) {
            String poiEntityLon = reduceCoordinateRadius(poiEntity.getLon(), radius);
            String currentLatNew = reduceCoordinateRadius(currentLat, radius);
            String poiEntityLat = reduceCoordinateRadius(poiEntity.getLat(), radius);
            String currentLonNew = reduceCoordinateRadius(currentLon, radius);
            if (poiEntityLat.equals(currentLatNew) &&
            poiEntityLon.equals(currentLonNew)) {
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
