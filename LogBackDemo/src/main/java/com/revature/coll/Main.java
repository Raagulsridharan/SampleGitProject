package com.revature.coll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        System.out.println("First Example for Logging.......");

        logger.info("Example log from {}", Main.class.getSimpleName());
        logger.debug("Example log from {}", Main.class.getSimpleName());
        logger.warn("Example log from {}", Main.class.getSimpleName());

        System.out.println("Ending the main method .....");
    }
}