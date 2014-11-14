package controllers;

import models.FoodResults;
import models.TruckModel;
import org.apache.commons.lang.StringUtils;
import play.cache.Cache;
import play.mvc.Controller;
import utils.SodaQueryManager;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void trucks(String q) {
        if (StringUtils.isEmpty(q)) {
            return;
        }

        List<TruckModel> locations = getTruckListing(q);
        FoodResults results = new FoodResults();
        results.size = locations.size();
        results.truckModelList = locations;
        renderJSON(results);
    }

    private static List<TruckModel> getTruckListing(String searchStr) {
        List<TruckModel> locations = new ArrayList<TruckModel>();
        boolean isInit = false;
        if (searchStr == null) {
            isInit = true;
            locations = (List<TruckModel>) Cache.get("init-map");
        }

        if (locations == null || locations.size() == 0) {
            SodaQueryManager mgr = new SodaQueryManager();
            locations = mgr.searchFoodTrucks(searchStr);
            if (isInit) {
                Cache.set("init-map", locations);
            }
        }
        return locations;
    }

    public static void initializeMap() {
        List<TruckModel> locations = getTruckListing(null);
        FoodResults results = new FoodResults();
        results.size = locations.size();
        results.truckModelList = locations;
        renderJSON(results);
    }

}