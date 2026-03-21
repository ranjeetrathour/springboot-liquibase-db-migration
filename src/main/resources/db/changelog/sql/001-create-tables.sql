--liquibase formatted sql

--changeset ranjeet-rathour:001
CREATE TABLE IF NOT EXISTS school
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255)
);