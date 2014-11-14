package controllers;

import play.Play;

/**
 * Created by rashok on 11/12/14.
 */
public class AppConstants {

    public static final String MAP_API_KEY = Play.configuration.getProperty("leaflet.api.key");
    public static final String MAP_ID = Play.configuration.getProperty("leaflet.map.id");
}
