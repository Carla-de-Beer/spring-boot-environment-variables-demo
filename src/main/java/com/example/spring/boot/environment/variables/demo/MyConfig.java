package com.example.spring.boot.environment.variables.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mls.config")
public class MyConfig {

    private FeatureFlags featureFlags;

    public FeatureFlags getFeatureFlags() {
        return featureFlags;
    }

    public void setFeatureFlags(FeatureFlags featureFlags) {
        this.featureFlags = featureFlags;
    }

    public static class FeatureFlags {

        private boolean abgaenge;
        private boolean rtme2101AuditLogs;
        private String rtme1470MultiEdit;
        private boolean testFlag;

        public boolean isAbgaenge() {
            return abgaenge;
        }

        public void setAbgaenge(boolean abgaenge) {
            this.abgaenge = abgaenge;
        }

        public boolean isRtme2101AuditLogs() {
            return rtme2101AuditLogs;
        }

        public void setRtme2101AuditLogs(boolean rtme2101AuditLogs) {
            this.rtme2101AuditLogs = rtme2101AuditLogs;
        }

        public String getRtme1470MultiEdit() {
            return rtme1470MultiEdit;
        }

        public void setRtme1470MultiEdit(String rtme1470MultiEdit) {
            this.rtme1470MultiEdit = rtme1470MultiEdit;
        }

        public boolean isTestFlag() {
            return testFlag;
        }

        public void setTestFlag(boolean testFlag) {
            this.testFlag = testFlag;
        }
    }

}