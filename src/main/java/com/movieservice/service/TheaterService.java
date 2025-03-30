package com.movieservice.service;


import com.movieservice.entity.Theater;
import com.movieservice.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

   
}
