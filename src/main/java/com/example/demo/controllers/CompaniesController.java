package com.example.demo.controllers;

import com.example.demo.services.abstracts.CompanyService;
import com.example.demo.entities.Company;
import com.example.demo.services.dtos.company.requests.AddCompanyRequest;
import com.example.demo.services.dtos.company.requests.DeleteCompanyRequest;
import com.example.demo.services.dtos.company.requests.UpdateCompanyRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompaniesController {


    public final CompanyService companyService;

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
    public String add(@RequestBody AddCompanyRequest request){

        companyService.add(request);
        return "Company added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteCompanyRequest request){
        companyService.delete(request);
        return "Company deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateCompanyRequest request){
        companyService.update(request);
        return "Company updated";
    }
}
