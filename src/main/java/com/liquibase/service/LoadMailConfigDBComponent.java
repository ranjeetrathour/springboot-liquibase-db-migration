package com.liquibase.service;

import com.liquibase.entity.MailConfig;
import com.liquibase.repository.MailConfigRepository;
import com.liquibase.utils.RunningCurrentEmailConfig;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component("mailConfigInitlizer")
@AllArgsConstructor
public class LoadMailConfigDBComponent {

    private final MailConfigRepository mailConfigRepository;

    @PostConstruct
    public void loadConfig() {
        MailConfig config = mailConfigRepository.findById(1L).orElse(null);
        if (config != null) {
            RunningCurrentEmailConfig.setCurrentMailConfig(config);
            System.out.println("MailConfig loaded at startup");
        } else {
            System.err.println("No MailConfig found in DB!");
        }
    }
}
