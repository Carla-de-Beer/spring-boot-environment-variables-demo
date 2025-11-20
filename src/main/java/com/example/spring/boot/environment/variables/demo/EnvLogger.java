package com.example.spring.boot.environment.variables.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvLogger implements CommandLineRunner {

    private MyConfig myConfig;

    public EnvLogger(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== ENV VARIABLES ===");
        System.getenv().forEach((k, v) -> System.out.println(k + "=" + v));

        System.out.println("isRtme2101AuditLogs: " + myConfig.getFeatureFlags().isRtme2101AuditLogs());
        System.out.println("isAbgaenge: " + myConfig.getFeatureFlags().isAbgaenge());
        System.out.println("getRtme1470MultiEdit: " + myConfig.getFeatureFlags().getRtme1470MultiEdit());
    }
}