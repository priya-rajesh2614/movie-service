package com.movieservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieservice.entity.Show;

public interface ShowRepository extends JpaRepository<Show,Long> {
	List<Show> findByMovieIdAndTheaterIdAndShowTimeAfter(Long movieId, Long theaterId, LocalDateTime currentTime);
}
