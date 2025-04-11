package com.movieservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_theater")
public class MovieTheater {

    @EmbeddedId
    private MovieTheaterId id;
    
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("theaterId")
    @JoinColumn(name = "theater_id")
    private Theater theater;

	public MovieTheaterId getId() {
		return id;
	}

	public void setId(MovieTheaterId id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

   
}
