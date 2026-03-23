--liquibase formatted sql

--changeset ranjeet-rathour:001
--precondition-sql-check exceptedResult:0 select count(*) from information.schema.tables where table_name="school"
CREATE TABLE IF NOT EXISTS school
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255)
);