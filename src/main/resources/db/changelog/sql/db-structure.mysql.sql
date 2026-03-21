-- liquibase formatted sql

-- changeset ranje:1774072003513-1
CREATE TABLE school (id BIGINT NOT NULL, name VARCHAR(255) NULL, city VARCHAR(255) NULL, CONSTRAINT PK_SCHOOL PRIMARY KEY (id));

