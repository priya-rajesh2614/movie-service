CREATE SCHEMA IF NOT EXISTS movietick;

CREATE TABLE movietick.users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

ALTER TABLE movietick.users
ADD COLUMN name VARCHAR(255) NOT NULL;

ALTER TABLE movietick.users
ADD COLUMN is_admin boolean default false;

CREATE TABLE movietick.movies (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    language VARCHAR(50) NOT NULL,
    duration INT NOT NULL,  
    description TEXT,
    image_url VARCHAR(500)
);

CREATE TABLE movietick.theaters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location TEXT NOT NULL,
    image_url VARCHAR(500) NOT NULL
);


CREATE TABLE movietick.movie_theater (
    movie_id BIGINT NOT NULL,
    theater_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, theater_id),
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    FOREIGN KEY (theater_id) REFERENCES theaters(id) ON DELETE CASCADE
);

CREATE TABLE movietick.shows (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    theater_id BIGINT NOT NULL,
    show_time DATETIME NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    FOREIGN KEY (theater_id) REFERENCES theaters(id) ON DELETE CASCADE
);

CREATE TABLE movietick.seats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    show_id BIGINT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    is_booked BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (show_id) REFERENCES shows(id) ON DELETE CASCADE
);

CREATE TABLE movietick.payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(100) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    payment_method VARCHAR(100),
    amount DOUBLE,
    payment_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50)
);

CREATE TABLE movietick.payment_seat_ids (
    payment_id BIGINT,
    seat_id BIGINT,
    PRIMARY KEY (payment_id, seat_id),
    FOREIGN KEY (payment_id) REFERENCES payments(id),
    FOREIGN KEY (seat_id) REFERENCES seats(id)
);
