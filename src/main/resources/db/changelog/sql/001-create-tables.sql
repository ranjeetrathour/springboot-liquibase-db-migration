--liquibase formatted sql

--changeset ranjeet-rathour:001
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM information_schema.tables WHERE table_name='school'

CREATE TABLE IF NOT EXISTS school
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255)
    );

--changeset ranjeet-rathour:002
--preconditions onFail:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'liquibase_db' AND TABLE_NAME = 'school' AND COLUMN_NAME = 'student_type';
ALTER TABLE school
    ADD COLUMN student_type VARCHAR(50);


-- changeset ranje:1774073410776-1
-- INSERT INTO school (id, name, city) VALUES (1, 'a', 'a');