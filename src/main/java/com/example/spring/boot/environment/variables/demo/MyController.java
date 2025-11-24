package com.example.spring.boot.environment.variables.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class MyController {

    private MyConfig myConfig;

    public MyController(MyConfig myConfig) {
        this.myConfig = myConfig;
    }

    @GetMapping("display-feature-flags")
    public String displayFeatureFlagsWithOverride() {
        MyConfig.FeatureFlags featureFlags = myConfig.getFeatureFlags();
        return """
                Linux environment variables cannot contain dots or dashes,
                so Spring Boot replaces dots with underscores and removes dashes when mapping environment variables to property names.
                Like it says in the Spring documentation.
                
                In application.yml and application.properties dashes in key names are allowed for readability,
                and Spring Boot’s relaxed binding rules ensure that these dashed keys still map correctly to the corresponding environment variables,
                even though the dashes are removed in the environment variable form.
                
                Spring Boot 🌱 🥾 handles these differences automatically through its relaxed binding mechanism.
                
                xyz:
                  config:
                    feature-flags:
                      rtme-1470-multi-edit: "345678"
                
                This maps to the following Linux environment variable:
                XYZ_CONFIG_FEATUREFLAGS_RTME1470MULTIEDIT=%s
                
                xyz.config.feature-flags.rtme-2618-abgaenge=qwerty
                
                This maps to the following Linux environment variable:
                XYZ_CONFIG_FEATUREFLAGS_RTME2618ABGAENGE=%s
                """.formatted(featureFlags.getRtme1470MultiEdit(), featureFlags.getRtme2618Abgaenge());
    }

}
