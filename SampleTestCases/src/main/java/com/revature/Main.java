package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {
        System.out.println("First Example for Logging.......");
        logger.info("Example log from {}", Calculator.class.getSimpleName());
        logger.debug("Example log from {}", Calculator.class.getSimpleName());
        logger.warn("Example log from {}", Calculator.class.getSimpleName());

        System.out.println("Ending the main method .....");
    }
}