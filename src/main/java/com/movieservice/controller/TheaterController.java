package com.movieservice.controller;


import com.movieservice.entity.Theater;
import com.movieservice.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
@CrossOrigin(origins = "http://localhost:3000") // Enable CORS for React frontend
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    
}
