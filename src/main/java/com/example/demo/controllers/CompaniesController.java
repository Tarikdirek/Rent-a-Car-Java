package com.example.demo.controllers;

import com.example.demo.services.abstracts.CompanyService;
import com.example.demo.services.dtos.company.requests.AddCompanyRequest;
import com.example.demo.services.dtos.company.requests.DeleteCompanyRequest;
import com.example.demo.services.dtos.company.requests.UpdateCompanyRequest;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponse;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponseWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompaniesController {


    public final CompanyService companyService;

    @GetMapping("getAll")
    public List<GetListCompanyResponseWithId> getALl() {
        return  companyService.getALl();

    }

    @GetMapping("/getById/{id}")
    public GetListCompanyResponseWithId getById(@PathVariable int id) {
        return companyService.getById(id);

    }

    @GetMapping("getCompanyWhichPhoneNotNull")
    public List<GetListCompanyResponse> findCompanyWhichPhoneNotNull() {
        return companyService.findCompanyWhichPhoneNotNull();
    }

    @GetMapping("getByCompanyNameWithUpperCase")
    public List<GetListCompanyResponse> getByCompanyNameWithUpperCase() {
        return companyService.getByCompanyNameWithUpperCase();
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid AddCompanyRequest request){

        companyService.add(request);
        return "Company added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteCompanyRequest request){
        companyService.delete(request);
        return "Company deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdateCompanyRequest request){
        companyService.update(request);
        return "Company updated";
    }
}
