package models;

import com.sun.jersey.api.client.GenericType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Simple POJO or Model class to store the attributes of a Food Truck
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TruckModel {

    String objectid;
    String applicant;
    String latitude;
    String address;
    String fooditems;
    String longitude;
    String status;
    String facilitytype;
    String locationdescription;

    public static final GenericType<List<TruckModel>> LIST_TYPE = new GenericType<List<TruckModel>>() {};

    public TruckModel(
            @JsonProperty("objectid") String objectid,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("address") String address,
            @JsonProperty("status") String status,
            @JsonProperty("fooditems") String fooditems,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("locationdescription") String locationdescription,
            @JsonProperty("facilitytype") String facilitytype,
            @JsonProperty("applicant") String applicant) {
        this.objectid = objectid;
        this.applicant = applicant;
        this.latitude = latitude;
        this.address = address;
        this.fooditems = fooditems;
        this.longitude = longitude;
        this.facilitytype = facilitytype;
        this.status = status;
        this.locationdescription = locationdescription;
    }

    @JsonProperty("applicant")
    public String getApplicant() {
        return applicant;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
}
