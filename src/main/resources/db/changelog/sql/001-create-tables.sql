--liquibase formatted sql

--changeset ranjeet-rathour:001
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.tables WHERE table_name='school'

CREATE TABLE IF NOT EXISTS school
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255)
    );

-- changeset ranje:1774073410776-1
INSERT INTO school (id, name, city) VALUES (1, 'a', 'a');