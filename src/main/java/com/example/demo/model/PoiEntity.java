package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "poi_entity")
public class PoiEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String urlImage;
    private String lon;
    private String lat;

    public PoiEntity() {
        super();
    }

    public PoiEntity(String name, String description, String urlImage, String lon, String lat) {
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
        this.lon = lon;
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
