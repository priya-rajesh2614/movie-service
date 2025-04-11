package com.movieservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movieservice.entity.Seat;
import com.movieservice.repository.SeatRepository;

@Service
public class SeatService {
	 
	private final SeatRepository seatRepository;

	public SeatService(SeatRepository seatRepository) {
		this.seatRepository = seatRepository;
	}
	
	public List<Seat> getSeats(Long showId){
		return seatRepository.findByShowId(showId);
	}
	
}
