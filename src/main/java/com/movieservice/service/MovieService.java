package com.movieservice.service;


import org.springframework.stereotype.Service;

import com.movieservice.entity.Movie;
import com.movieservice.entity.Theater;
import com.movieservice.repository.MovieRepository;

import java.util.List;
import java.util.Set;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
		
		this.movieRepository = movieRepository;
	}

	public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

	public Set<Theater> getTheatersByMovie(Long movieId) {
		 Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
	        return movie.getTheaters();
	}

	public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
