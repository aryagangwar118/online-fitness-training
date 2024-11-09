CREATE DATABASE fitness_training;

USE fitness_training;

-- Users table (for general users or clients)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Trainers table
CREATE TABLE trainers (
    trainer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    bio TEXT,
    email VARCHAR(100) NOT NULL
);

-- Sessions table (for training sessions)
CREATE TABLE sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    session_name VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    trainer_id INT,
    FOREIGN KEY (trainer_id) REFERENCES trainers(trainer_id)
);

-- Registrations table (for users registering for sessions)
CREATE TABLE registrations (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    session_id INT,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (session_id) REFERENCES sessions(session_id)
);
