package com.example.spring.boot.environment.variables.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class MyController {

    private MyConfig myConfig;

    public MyController(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    @GetMapping("multi-edit")
    public String sayHelloMultiEdit() {
        return """
                Hello Gregor!
                You were right in that the environment variables need to be written without underscores and dots for Linux.
                I did not know that until today.
                However, we can use them with dashes inside the application.yml file. 😀
                Spring Boot 🌱 🥾 will correctly interpret them due to the relaxed binding rules.
                This is my multi edit env variable's value: %s
                """.formatted(myConfig.getFeatureFlags().getRtme1470MultiEdit());
    }

    @GetMapping("audit-log")
    public String isAuditLogTrue() {
        return "Value of audit log env variable: " + myConfig.getFeatureFlags().isRtme2101AuditLogs();
    }
}
