package com.order.service;

import com.order.api.service.ILogger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class Logger implements ILogger {
    private static  final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");
    private Handler fileHandler = new FileHandler("src/resources/log/log.txt");

    public Logger() throws IOException {
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
    }
    @Override
    public void info(String msg){
        logger.info(msg);
    }
}
