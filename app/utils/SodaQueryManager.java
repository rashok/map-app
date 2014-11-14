package utils;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import models.TruckModel;
import org.apache.commons.lang.StringUtils;
import play.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Query Manager class to perform search query on the remote data set
 * via the Socrata API.
 */
public class SodaQueryManager {

    private Soda2Consumer consumer = null;

    public SodaQueryManager() {
        try {
            consumer = SodaConnection.getConsumer();
        } catch (IOException e) {
            Logger.error(e, "IO Exception Occurred while trying to establish a connection with SODA API.");
        }
    }

    public List<TruckModel> searchFoodTrucks(String searchString)  {
        List<TruckModel> locations = new ArrayList<TruckModel>();
        List<TruckModel> filteredTrucks = new ArrayList<TruckModel>();

        SoqlQueryBuilder builder = new SoqlQueryBuilder()
                .addSelectPhrase("objectid")
                .addSelectPhrase("applicant")
                .addSelectPhrase("status")
                .addSelectPhrase("address")
                .addSelectPhrase("fooditems")
                .addSelectPhrase("latitude")
                .addSelectPhrase("longitude")
                .addSelectPhrase("facilitytype")
                .addSelectPhrase("locationdescription");

        if (!StringUtils.isEmpty(searchString)) {
            builder.setFullTextSearchClause(searchString);
        }

        SoqlQuery query = builder.build();
        try {
            locations = this.consumer.query("rqzj-sfat", query, TruckModel.LIST_TYPE);
            if (locations != null && locations.size() > 0) {
                for (TruckModel m : locations) {
                    if (m.getStatus().equalsIgnoreCase("Approved") && (m.getLatitude() != null || m.getLongitude() != null)) {
                        filteredTrucks.add(m);
                    }
                }
            }
        } catch (SodaError sodaError) {
            sodaError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return filteredTrucks;
    }


}
