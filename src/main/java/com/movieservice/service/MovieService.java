package com.movieservice.service;


import org.springframework.stereotype.Service;

import com.movieservice.entity.Movie;
import com.movieservice.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
		
		this.movieRepository = movieRepository;
	}

	public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
