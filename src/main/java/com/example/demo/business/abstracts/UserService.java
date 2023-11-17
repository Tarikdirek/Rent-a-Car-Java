package com.example.demo.business.abstracts;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
}
