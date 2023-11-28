package com.example.demo.controllers;

import com.example.demo.services.abstracts.IndividualService;
import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.example.demo.services.dtos.individual.requests.DeleteIndividualRequest;
import com.example.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/individuals")
@AllArgsConstructor
public class IndividualsController {


    public final IndividualService individualService;


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

    @GetMapping("/getIndividualByBirthDate")
    public List<GetListIndividualResponse> getIndividualByBirthDate(int birthYear) {
        return individualService.getIndividualByBirthDate(birthYear);
    }

    @GetMapping("/getIndividualByFirstNameDesc")
    public List<GetListIndividualResponse> getIndividualByFirstNameDesc() {
        return individualService.getIndividualByFirstNameDesc();
    }


    @PostMapping("/add")
    public String add(@RequestBody AddIndividualRequest request){

        individualService.add(request);

        return "User added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteIndividualRequest request){
        individualService.delete(request);
        return "User deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateIndividualRequest request){
        individualService.update(request);
        return "User updated";
    }

}
