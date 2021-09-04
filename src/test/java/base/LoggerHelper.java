package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.trace("This is my trace message");
        logger.debug("This is my debug message");
        logger.info("This is my information message");
        logger.warn("This is my warn message");
        logger.fatal("This is my fatal message");
        logger.error("This is my error message");
        System.out.println("Class completed");
    }

    public static Logger getLoggerHelper(Class cls){
        return LogManager.getLogger(cls);
    }

}
