package com.bjfu.inspect.common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static  Logger logger  = null;
    public static void info(Class c, String log){
        logger = LoggerFactory.getLogger(c);
        logger.info(log);
    }
}
