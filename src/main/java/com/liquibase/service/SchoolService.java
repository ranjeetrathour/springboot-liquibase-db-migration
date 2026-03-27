package com.liquibase.service;

import com.liquibase.entity.School;
import com.liquibase.repository.SchoolRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final JavaMailSender dynamicMailSender;

    public SchoolService(SchoolRepository repository, JavaMailSender dynamicMailSender) {
        this.repository = repository;
        this.dynamicMailSender = dynamicMailSender;
    }

    public List<School> getAllSchools() {
        return repository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        sendTestEmail("ranjeet.rathour@moptra.com");
        return repository.findById(id);
    }

    public School createSchool(School school) {
        return repository.save(school);
    }

    public School updateSchool(Long id, School school) {
        school.setId(id);
        return repository.save(school);
    }

    public void deleteSchool(Long id) {
        repository.deleteById(id);
    }

    public void sendTestEmail(String toEmail) {
        try {

            MimeMessage message = dynamicMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject("Test Email from Dynamic Config");
            helper.setText("<h3>Test Email </h3><p>Your dynamic SMTP config is working!</p>", true);

            dynamicMailSender.send(message);

            System.out.println("Test email sent successfully");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}