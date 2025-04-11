package com.movieservice.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="movie_id",nullable=false)
	private Movie movie;
	

	@ManyToOne
	@JoinColumn(name="theater_id",nullable=false)
	private Theater theater;
	
	private LocalDateTime showTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}
}
