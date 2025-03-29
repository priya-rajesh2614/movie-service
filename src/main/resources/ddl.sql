CREATE SCHEMA IF NOT EXISTS movietick;

CREATE TABLE movietick.users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

ALTER TABLE movietick.users
ADD COLUMN name VARCHAR(255) NOT NULL;

CREATE TABLE movietick.movies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    language VARCHAR(50) NOT NULL,
    duration INT NOT NULL,  
    description TEXT,
    image_url VARCHAR(500)
);
