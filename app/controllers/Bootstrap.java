package controllers;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import utils.SodaConnection;

import java.io.IOException;

@OnApplicationStart
public class Bootstrap extends Job {

    public Bootstrap() {
        Logger.info("no of processors %s", Runtime.getRuntime().availableProcessors());
    }

    public void doJob() {
        try {
            SodaConnection.getConsumer();
        } catch (IOException e) {
            Logger.error(e, "Exception while trying to initialize the Soda Service.");
        }
    }
}
