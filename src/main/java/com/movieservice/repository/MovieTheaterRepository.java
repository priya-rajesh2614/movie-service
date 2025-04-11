package com.movieservice.repository;

import com.movieservice.entity.MovieTheater;
import com.movieservice.entity.MovieTheaterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterRepository extends JpaRepository<MovieTheater, MovieTheaterId> {
}
