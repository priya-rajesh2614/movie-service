package com.movieservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieservice.entity.Seat;
import com.movieservice.service.SeatService;


@RestController
@RequestMapping("/movies/{movieId}/theaters/{theaterId}/shows/{showId}/seats")
public class SeatController {
	
	private SeatService seatService;

	public SeatController(SeatService seatService) {
		this.seatService = seatService;
	}
	
	@GetMapping
	public List<Seat> getSeats(@PathVariable Long showId){
		return seatService.getSeats(showId);
	}

}
