package com.smartviewholder;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class ExcellentAdventure {

    @Retention(SOURCE)
    @StringDef({ERA_BC, ERA_AD})
    public @interface Era {
    }

    public static final String ERA_BC = "BC";
    public static final String ERA_AD = "AD";

    private int year;
    @Era private String era;
    private String title;
    private String lat;
    private String lon;
    private String locationName;
    private String wikipediaTitle;

    public ExcellentAdventure(int year, String era, String title,
                              String lat, String lon,
                              String locationName,
                              String wikipediaTitle) {
        this.year = year;
        this.era = era;
        this.title = title;
        this.lat = lat;
        this.lon = lon;
        this.locationName = locationName;
        this.wikipediaTitle = wikipediaTitle;
    }

    public int getYear() { return year; }

    @Era public String getEra() { return era; }

    public String getTitle() { return title; }

    public String getLat() { return lat; }

    public String getLon() { return lon; }

    public String getLocationName() { return locationName; }

    public String getWikipediaTitle() { return wikipediaTitle; }
}
