package com.movieservice.controller;

import org.springframework.web.bind.annotation.*;

import com.movieservice.entity.Movie;
import com.movieservice.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
		
		this.movieService = movieService;
	}

	@GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


   
}
