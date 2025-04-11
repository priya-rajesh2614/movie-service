package com.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieservice.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowId(Long showId);

	List<Seat> findByIdIn(List<Long> selectedSeats);
}
