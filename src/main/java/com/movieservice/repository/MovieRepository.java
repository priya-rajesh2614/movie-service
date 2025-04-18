package com.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieservice.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
