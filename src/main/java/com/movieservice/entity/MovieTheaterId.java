package com.movieservice.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieTheaterId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long movieId;
    private Long theaterId;

    public MovieTheaterId() {}

    public MovieTheaterId(Long movieId, Long theaterId) {
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }



    @Override
    public int hashCode() {
        return Objects.hash(movieId, theaterId);
    }
}
