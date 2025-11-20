package com.example.spring.boot.environment.variables.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvLogger implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(EnvLogger.class);

    private MyConfig myConfig;

    public EnvLogger(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    @Override
    public void run(String... args) {
        logger.info("--- ENV VARIABLES ---");
        System.getenv().forEach((k, v) -> logger.info("{}={}", k, v));

        logger.info("isRtme2101AuditLogs: {}", myConfig.getFeatureFlags().isRtme2101AuditLogs());
        logger.info("myProperty: {}", myConfig.getFeatureFlags().isMyProperty());
        logger.info("getRtme1470MultiEdit: {}", myConfig.getFeatureFlags().getRtme1470MultiEdit());
    }
}