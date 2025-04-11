package com.movieservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movieservice.entity.Movie;
import com.movieservice.entity.MovieTheater;
import com.movieservice.entity.MovieTheaterId;
import com.movieservice.entity.Seat;
import com.movieservice.entity.Show;
import com.movieservice.entity.Theater;
import com.movieservice.repository.MovieRepository;
import com.movieservice.repository.MovieTheaterRepository;
import com.movieservice.repository.SeatRepository;
import com.movieservice.repository.ShowRepository;
import com.movieservice.repository.TheaterRepository;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final MovieTheaterRepository movieTheaterRepository;

    public ShowService(ShowRepository showRepository, SeatRepository seatRepository,MovieRepository movieRepository, TheaterRepository theaterRepository,MovieTheaterRepository movieTheaterRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.movieTheaterRepository = movieTheaterRepository;
    }

    public List<Show> getShows(Long movieId, Long theaterId) {
        return showRepository.findByMovieIdAndTheaterId(movieId, theaterId);
    }

    public Show addShow(Long movieId, Long theaterId, Show show) {
    	 Optional<Movie> movie = movieRepository.findById(movieId);
    	 Optional<Theater> theater = theaterRepository.findById(theaterId);
        show.setMovie(movie.get());
        show.setTheater(theater.get());
        Show savedShow = showRepository.save(show);
        
        MovieTheaterId movieTheaterId = new MovieTheaterId(movieId, theaterId);
        if (!movieTheaterRepository.existsById(movieTheaterId)) {
            MovieTheater movieTheater = new MovieTheater();
            movieTheater.setId(movieTheaterId);
            movieTheater.setMovie(movie.get());
            movieTheater.setTheater(theater.get());
            movieTheaterRepository.save(movieTheater);
        }

        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            Seat seat = new Seat();
            seat.setShow(savedShow);
            seat.setSeatNumber("S" + i);
            seat.setIsBooked(false);
            seats.add(seat);
        }
        seatRepository.saveAll(seats);

        return savedShow;
    }
}
