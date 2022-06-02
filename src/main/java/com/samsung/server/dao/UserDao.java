package com.samsung.server.dao;

import com.samsung.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

}
