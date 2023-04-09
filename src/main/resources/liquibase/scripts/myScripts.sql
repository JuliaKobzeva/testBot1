-- liquibase formatted sql

-- changeset jkobzeva:1

CREATE TABLE owners_reports
(
    id  SERIAL NOT NULL PRIMARY KEY,
    chat_id BIGINT,
    name TEXT,
    pet_type TEXT,
    string_report TEXT,
    photo_report BYTEA,
    last_report timestamp,
    start_probation timestamp,
    probationary_status TEXT,
    period_extend INTEGER
)
