package flightSim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class SimulatorLogger {
    private static SimulatorLogger simulatorLogger = null;
    private Logger logger = Logger.getLogger("global");

    private SimulatorLogger() {

        FileHandler fh = null;

        try {
            fh = new FileHandler("simulation.txt");
        } catch (IOException e) {
            System.out.println("error: could not open simulation log file");
            System.exit(1);
        }

        fh.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage();
            }
        });
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
    }

    private static SimulatorLogger getLogger() {
        if (simulatorLogger == null) {
            simulatorLogger = new SimulatorLogger();
        }
        return simulatorLogger;
    }

    public static void put(String s) {
        getLogger().logger.info(s);
    }

}