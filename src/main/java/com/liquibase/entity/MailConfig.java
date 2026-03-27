package com.liquibase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailConfig {

    @Id
    private Long id;

    private String host;
    private Integer port;
    private String username;
    private String password;
    private Boolean auth;
    private Boolean starttls;

}
