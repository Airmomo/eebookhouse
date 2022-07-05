package com.eebookhouse.service;

import com.eebookhouse.entity.User;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    boolean auth(String username, String password, HttpSession session);
    boolean register(String username, String password, HttpSession session);
    User getUserById(Integer id);
    boolean updateUser(User user);
}
