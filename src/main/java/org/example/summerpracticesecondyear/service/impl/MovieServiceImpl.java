package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl {

    private final MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }
}
