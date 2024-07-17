package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.dto.UserDto;
import org.example.summerpracticesecondyear.entities.Movie;
import org.example.summerpracticesecondyear.entities.User;
import org.example.summerpracticesecondyear.repositories.MovieRepository;
import org.example.summerpracticesecondyear.repositories.UserRepository;
import org.example.summerpracticesecondyear.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final MovieRepository movieRepo;

    public UserServiceImpl(UserRepository userRepo, MovieRepository movieRepo) {
        this.userRepo = userRepo;
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> selectCompilationListByUserId(Long userId) {
        userRepo.findGenreByUserId(userId);
        return (List<Movie>) movieRepo.findAll();
    }
}
