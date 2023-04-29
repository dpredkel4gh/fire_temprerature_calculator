package by.pvt.predkel.utils;

public class Logger {
    private org.apache.log4j.Logger logger;
    private static Logger instance;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logError(Class sender, String message) {
        logger = org.apache.log4j.Logger.getLogger(sender);
        logger.error(message);
    }


}