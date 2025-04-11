package com.movieservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieservice.entity.Show;
import com.movieservice.service.ShowService;
@RestController
@RequestMapping("/movies/{movieId}/theaters/{theaterId}/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getShows(@PathVariable Long movieId, @PathVariable Long theaterId) {
        return showService.getShows(movieId, theaterId);
    }

    @PostMapping
    public ResponseEntity<Show> addShow(
            @PathVariable Long movieId,
            @PathVariable Long theaterId,
            @RequestBody Show show
    ) {
        Show savedShow = showService.addShow(movieId, theaterId, show);
        return ResponseEntity.ok(savedShow);
    }
}
