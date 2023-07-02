package com.order.utils;

import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    Logger logger = LogManager.getLogger(Main.class);

    public void debug(String debugMsg){
        logger.debug(debugMsg);
    }
    public void error(String errorMsg){
        logger.debug(errorMsg);
    }
    public void fatal(String fatalMsg){
        logger.debug(fatalMsg);
    }
    public void info(String infoMsg){
        logger.info(infoMsg);
    }
    public void trace(String traceMsg){
        logger.trace(traceMsg);
    }
}