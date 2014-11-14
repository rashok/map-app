package controllers;

import play.Play;

/**
 * Created by rashok on 11/12/14.
 */
public class AppConstants {

    public static final String MAP_API_KEY = Play.configuration.getProperty("leaflet.api.key");
    public static final String MAP_ID = Play.configuration.getProperty("leaflet.map.id");

    public static final String SOCRATA_USER = Play.configuration.getProperty("socrata.user");
    public static final String SOCRATA_PASS = Play.configuration.getProperty("socrata.pass");
    public static final String SOCRATA_TOKEN = Play.configuration.getProperty("food.truck.app.token");

}
