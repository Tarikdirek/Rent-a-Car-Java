package com.example.demo.controllers;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController  {


    UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user){

        userService.add(user);
        return "Kullanıcı eklendi";
    }

    @GetMapping("/getall")
    public List<User> getAll(){
       return userService.getAll();

    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable int id) {
        var result =userService.getById(id);
        return result;
    }










}
