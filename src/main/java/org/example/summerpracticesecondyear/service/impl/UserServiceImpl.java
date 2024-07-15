package org.example.summerpracticesecondyear.service.impl;

import org.example.summerpracticesecondyear.dto.UserDto;
import org.example.summerpracticesecondyear.entities.User;
import org.example.summerpracticesecondyear.repositories.UserRepository;
import org.example.summerpracticesecondyear.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Double getUserBalanceByUserId(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setBonusBalance(userDto.getBonusBalance());

        User newUser = userRepo.save(user);

        return newUser.getBonusBalance();
    }
}
