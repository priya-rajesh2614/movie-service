package com.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieservice.entity.Show;

public interface ShowRepository extends JpaRepository<Show,Long> {
	List<Show> findByMovieIdAndTheaterId(Long movieId,Long theaterId);
}
