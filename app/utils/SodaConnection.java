package utils;

import com.socrata.api.Soda2Consumer;

import java.io.IOException;

public class SodaConnection {

    private static Soda2Consumer consumer = null;
    private static SodaConnection connection = null;

    private SodaConnection() throws IOException {
        consumer = Soda2Consumer.newConsumer("https://data.sfgov.org",
                "raghuram.ashok@gmail.com",
                "thanks1234!",
                "9XN6slA1htgyrDnMoDDIaWoum");
    }

    public static Soda2Consumer getConsumer() throws IOException {
        if (connection == null) {
            connection = new SodaConnection();
        }
        return consumer;
    }
}
