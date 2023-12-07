package com.example.demo.controllers;

import com.example.demo.services.abstracts.IndividualService;
import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.example.demo.services.dtos.individual.requests.DeleteIndividualRequest;
import com.example.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponse;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponseWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;



@RestController
@RequestMapping("/api/individuals")
@AllArgsConstructor
public class IndividualsController {


    public final IndividualService individualService;


    @GetMapping("/getAll")
    public List<GetListIndividualResponseWithId> getAll(){
        return  individualService.getALl();

    }

    @GetMapping("/getById/{id}")
    public Individual getById(@PathVariable int id) {
        return  individualService.getById(id);

    }

    @GetMapping("/getIndividualByBirthDate")
    public List<GetListIndividualResponse> getIndividualByBirthDate(@RequestParam int birthYear) {
        return individualService.getIndividualByBirthDate(birthYear);
    }

    @GetMapping("/getIndividualByFirstNameDesc")
    public List<GetListIndividualResponse> getIndividualByFirstNameDesc() {
        return individualService.getIndividualByFirstNameDesc();
    }


    @PostMapping("/add")
    public String add(@RequestBody @Valid AddIndividualRequest request){

        individualService.add(request);

        return "User added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteIndividualRequest request){
        individualService.delete(request);
        return "User deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdateIndividualRequest request){
        individualService.update(request);
        return "User updated";
    }

}
