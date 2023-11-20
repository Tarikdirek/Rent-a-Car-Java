package com.example.demo.controllers;

import com.example.demo.business.abstracts.IndividualService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.entities.Individual;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/individuals")
@AllArgsConstructor
public class IndividualsController {

    @Autowired
    public final IndividualService individualService;
    public final UserService userService;



    @GetMapping("/getAll")
    public List<Individual> getAll(){
        var result = individualService.getALl();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Individual getById(@PathVariable int id) {
        var result =individualService.getById(id);
        return result;
    }


    @PostMapping("/add")
    public String add(@RequestBody Individual individual){

       // individualService.add(individual);
        userService.add(individual);

        return "User added";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        individualService.delete(id);
        return "User deleted";
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable int id,@RequestBody Individual individual){
        individualService.update(id,individual);
        return "User updated";
    }

}
