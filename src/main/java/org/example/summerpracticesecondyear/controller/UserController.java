package org.example.summerpracticesecondyear.controller;

import org.example.summerpracticesecondyear.dto.MovieDto;
import org.example.summerpracticesecondyear.dto.TicketDto;
import org.example.summerpracticesecondyear.dto.TicketInfoDto;
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
    public List<MovieDto> getCompilation(@PathVariable Long userId) {
        return userService.selectCompilationListByUserId(userId);
    }

    @GetMapping("/booking")
    public List<TicketDto> ticketBooking(@RequestBody TicketInfoDto ticketInfoDto) {
        userService.ticketOrdering(ticketInfoDto);
        return userService.findTicketsByUserId(ticketInfoDto.getUserId());
    }
}
