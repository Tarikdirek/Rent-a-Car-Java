package com.example.demo.controllers;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.entities.Company;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompaniesController {

    @Autowired
    public final CompanyService companyService;
    public final UserService userService;

    @GetMapping("getAll")
    public List<Company> getALl() {
        var result = companyService.getALl();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Company getById(int id) {
        var result =companyService.getById(id);
        return result;
    }

    @PostMapping("/add")
    public String add(@RequestBody Company company){

        // individualService.add(individual);
        userService.add(company);

        return "Company added";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        companyService.delete(id);
        return "Company deleted";
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable int id,@RequestBody Company company){
        companyService.update(id,company);
        return "Company updated";
    }
}
