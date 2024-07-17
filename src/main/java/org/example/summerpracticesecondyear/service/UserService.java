package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.projections.MovieType;

import java.util.List;

public interface UserService {
    List<MovieType> selectCompilationListByUserId(Long UserId);
}
