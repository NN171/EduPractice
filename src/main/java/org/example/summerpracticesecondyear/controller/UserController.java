package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.dto.TicketInfoDto;
import org.example.summerpracticesecondyear.projections.MovieType;
import org.example.summerpracticesecondyear.projections.TicketType;
import org.example.summerpracticesecondyear.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/compilation/{userId}")
    public List<MovieType> getCompilation(@PathVariable Long userId) {
        return userService.selectCompilationListByUserId(userId);
    }

    @GetMapping("/booking")
    public List<TicketType> ticketBooking(@RequestBody TicketInfoDto ticketInfoDto) {
        userService.ticketOrdering(ticketInfoDto);
        return userService.findTicketsByUserId(ticketInfoDto.getUserId());
    }
}
