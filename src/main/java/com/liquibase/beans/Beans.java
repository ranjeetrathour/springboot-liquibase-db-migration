package com.liquibase.beans;

import com.liquibase.entity.MailConfig;
import com.liquibase.utils.RunningCurrentEmailConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Beans {

    @Bean
    @DependsOn("mailConfigInitlizer")
    public JavaMailSender javaMailSender() {
        MailConfig config = RunningCurrentEmailConfig.getCurrentMailConfig();
        if (config == null) {
            throw new IllegalStateException("Mail config not loaded yet");
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());
        mailSender.setUsername(config.getUsername());
        mailSender.setPassword(config.getPassword());
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", config.isAuth());
        props.put("mail.smtp.starttls.enable", config.isStarttls());

        return mailSender;
    }
}