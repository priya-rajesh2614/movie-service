CREATE SCHEMA IF NOT EXISTS movietick;

CREATE TABLE movietick.users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
