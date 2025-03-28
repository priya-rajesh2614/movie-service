package com.movieservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.movieservice.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
