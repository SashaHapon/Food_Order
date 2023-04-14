package com.order.service;

import com.order.api.service.ILogger;

import java.io.IOException;
import java.util.logging.FileHandler;

public class Logger implements ILogger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");

    public Logger() {
        try {
            logger.setUseParentHandlers(false);
            logger.addHandler(new FileHandler("src/resources/log/log.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void info(String msg) {
        logger.info(msg);
    }
}
