package com.liquibase.repository;

import com.liquibase.entity.MailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailConfigRepository extends JpaRepository<MailConfig, Long> {
}
