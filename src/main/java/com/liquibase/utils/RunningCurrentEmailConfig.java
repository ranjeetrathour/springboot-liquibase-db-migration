package com.liquibase.utils;

import com.liquibase.entity.MailConfig;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class RunningCurrentEmailConfig {
    private RunningCurrentEmailConfig() {}

    private static final AtomicReference<MailConfig> currentMailConfig = new AtomicReference<>();

    public static void setCurrentMailConfig(MailConfig currentMail) {
        Objects.requireNonNull(currentMail, "MailConfig cannot be null");
        currentMailConfig.set(currentMail);
    }

    public static MailConfig getCurrentMailConfig() {
        return currentMailConfig.get();
    }
}
