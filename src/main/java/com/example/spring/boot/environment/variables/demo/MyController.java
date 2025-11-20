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
                Linux environment variables cannot contain dots or dashes (we agree on this),
                so Spring Boot replaces dots with underscores and removes dashes when mapping environment variables to property names.
                Like it said in the Spring documentation. I am now clear on this.
                In application.yml, the structure is defined entirely by indentation but dashes in YAML key names are allowed for readability,
                and Spring Boot’s relaxed binding rules ensure that these dashed keys still map correctly to the corresponding environment variables,
                even though the dashes are removed in the environment variable form.
                Spring Boot 🌱 🥾 handles these differences automatically through its relaxed binding mechanism.
                
                xyz:
                  config:
                    feature-flags:
                      rtme-1470-multi-edit: "345678"
                
                This maps to the following Linux environment variable:
                XYZ_CONFIG_FEATUREFLAGS_RTME1470MULTIEDIT=%s
                """.formatted(myConfig.getFeatureFlags().getRtme1470MultiEdit());
    }

    @GetMapping("audit-log")
    public String isAuditLogTrue() {
        return "Value of audit log env variable: " + myConfig.getFeatureFlags().isRtme2101AuditLogs();
    }
}
