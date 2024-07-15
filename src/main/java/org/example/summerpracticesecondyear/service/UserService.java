package org.example.summerpracticesecondyear.service;

import org.example.summerpracticesecondyear.dto.UserDto;

public interface UserService {
    Double getUserBalanceByUserId(UserDto userDto);
}
