package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.entities.Movie;

import java.util.List;

public interface UserService {
    List<Movie> selectCompilationListByUserId(Long UserId);
}
