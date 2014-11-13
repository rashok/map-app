package controllers;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import models.FoodResults;
import models.TruckModel;
import play.cache.Cache;
import play.mvc.Controller;
import utils.SodaConnection;

import java.io.IOException;
import java.util.List;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void initializeMap() {
        List<TruckModel> locations = (List<TruckModel>) Cache.get("init-map");
        if (locations == null) {
            Soda2Consumer consumer = null;
            try {
                consumer = SodaConnection.getConsumer();
                SoqlQuery query = new SoqlQueryBuilder()
                        .addSelectPhrase("objectid")
                        .addSelectPhrase("applicant")
                        .addSelectPhrase("address")
                        .addSelectPhrase("fooditems")
                        .addSelectPhrase("latitude")
                        .addSelectPhrase("longitude")
                        .addSelectPhrase("facilitytype")
                        .addSelectPhrase("locationdescription")
                        .setWhereClause("status='Approved' and latitude is not null and longitude is not null")
                        .build();

                locations = consumer.query("rqzj-sfat", query, TruckModel.LIST_TYPE);
                Cache.set("init-map", locations);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SodaError sodaError) {
                sodaError.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FoodResults results = new FoodResults();
        results.size = locations.size();
        results.truckModelList = locations;
        renderJSON(results);
    }

}