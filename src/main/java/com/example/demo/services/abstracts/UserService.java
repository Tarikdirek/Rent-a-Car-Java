package com.example.demo.services.abstracts;

import com.example.demo.entities.User;

import java.util.List;

public interface UserService {

    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
    User getById(int id);
}
