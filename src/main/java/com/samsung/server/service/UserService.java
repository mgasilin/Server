package com.samsung.server.service;

import com.samsung.server.domain.User;
import com.samsung.server.rest.dto.LoginDto;

public interface UserService {
     LoginDto login(String login, String password);

     LoginDto register(String login, String password, String username);

     User getById(int id);
}
