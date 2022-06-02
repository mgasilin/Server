package com.samsung.server.rest.controller;

import com.samsung.server.dao.CommentDao;
import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import com.samsung.server.rest.dto.LoginDto;
import com.samsung.server.rest.dto.UserDto;
import com.samsung.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable int id){
        return UserDto.toDto(userService.getById(id));
    }

    @GetMapping("/user/login")
    public LoginDto login(@RequestParam String login, @RequestParam String password){
        return userService.login(login,password);
    }

    @GetMapping("/user/register")
    public LoginDto register(@RequestParam String login, @RequestParam String password, @RequestParam String username){
        return  userService.register(login,password,username);
    }
}
