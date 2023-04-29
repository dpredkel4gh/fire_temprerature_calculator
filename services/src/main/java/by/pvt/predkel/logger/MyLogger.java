package by.pvt.predkel.logger;

import org.apache.log4j.Logger;

public enum MyLogger {
    INSTANCE;
    private Logger logger;

    @SuppressWarnings("rawtypes")
    public void logError(Class sender, String message) {
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}
