package com.example.demo.controller;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.business.abstracts.IndividualService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.model.IndividualUser;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController  {


    UserService userService;
    IndividualService individualService;
    CompanyService companyService;

    @Autowired
    public UsersController(UserService userService, IndividualService individualService, CompanyService companyService) {
        this.userService = userService;
        this.individualService = individualService;
        this.companyService = companyService;
    }



    @GetMapping("/getall")
    public List<User> getAll(){
       return userService.getAll();

    }


    @PostMapping("/create-individual-user")
    public String add(@RequestBody IndividualUser individualUser){

        individualService.add(individualUser.getIndividual());
        userService.add(individualUser);

        return "Kullanıcı eklendi";
    }



}
