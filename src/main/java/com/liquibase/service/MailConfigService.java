package com.liquibase.service;

import com.liquibase.entity.MailConfig;
import com.liquibase.repository.MailConfigRepository;
import com.liquibase.utils.RunningCurrentEmailConfig;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailConfigService {
    private final MailConfigRepository mailConfigRepository;

    public MailConfig getMailById(Long id){
        return mailConfigRepository.findById(id).orElse(null);
    }

}
