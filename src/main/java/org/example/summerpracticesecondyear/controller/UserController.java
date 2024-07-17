package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.entities.Movie;
import org.example.summerpracticesecondyear.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/compilation/{userId}")
    public List<Movie> getCompilation(@PathVariable Long userId) {
        return userService.selectCompilationListByUserId(userId);
    }
}
