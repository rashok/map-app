package utils;

import com.socrata.api.Soda2Consumer;
import controllers.AppConstants;

import java.io.IOException;

/**
 * Singleton class to intialize the Socrata Connection
 */
public class SodaConnection {

    private static Soda2Consumer consumer = null;
    private static SodaConnection connection = null;

    private SodaConnection() throws IOException {
        consumer = Soda2Consumer.newConsumer("https://data.sfgov.org", AppConstants.SOCRATA_USER, AppConstants.SOCRATA_PASS, AppConstants.SOCRATA_TOKEN);
    }

    public static Soda2Consumer getConsumer() throws IOException {
        if (connection == null) {
            connection = new SodaConnection();
        }
        return consumer;
    }
}
