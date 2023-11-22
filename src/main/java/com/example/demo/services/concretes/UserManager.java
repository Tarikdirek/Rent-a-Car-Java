package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.UserService;
import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserManager implements UserService {


    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.saveAndFlush(user);
    }

    public void delete(User user) {
            userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        var result = userRepository.findById(id).orElseThrow();
        return result;
    }


}
