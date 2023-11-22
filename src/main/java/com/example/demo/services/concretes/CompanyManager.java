package com.example.demo.services.concretes;

import com.example.demo.entities.User;
import com.example.demo.services.abstracts.CompanyService;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.entities.Company;
import com.example.demo.services.dtos.company.requests.AddCompanyRequest;
import com.example.demo.services.dtos.company.requests.DeleteCompanyRequest;
import com.example.demo.services.dtos.company.requests.UpdateCompanyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {


    private final CompanyRepository companyRepository;

    public void add(AddCompanyRequest request)
    {
        Company company = new Company();
        company.setEmail(request.getEmail());
        company.setPassword(request.getPassword());
        company.setCompanyName(request.getCompanyName());
        company.setTaxNum(request.getTaxNum());
        company.setWebAddress(request.getWebAddress());
        company.setPhone(request.getPhone());
        companyRepository.save(company);
    }

    public void update(UpdateCompanyRequest request) {
        Company companyToUpdate = companyRepository.findById(request.getId()).orElseThrow();
        companyToUpdate.setEmail(request.getEmail());
        companyToUpdate.setCompanyName(request.getCompanyName());
        companyToUpdate.setTaxNum(request.getTaxNum());
        companyToUpdate.setWebAddress(request.getWebAddress());
        companyToUpdate.setPhone(request.getPhone());
        companyToUpdate.setPassword(request.getPassword());
        companyRepository.saveAndFlush(companyToUpdate);
    }

    public void delete(DeleteCompanyRequest request) {
        Company companyToDelete = companyRepository.findById(request.getId()).orElseThrow();
        boolean checkPassword =(request.getPassword().equals(companyToDelete.getPassword()));
        if (!checkPassword) {
            throw new RuntimeException();
        }
        companyRepository.delete(companyToDelete);
    }

    public List<Company> getALl() {
        var result = companyRepository.findAll();
        return result;
    }

    public Company getById(int id) {
        var result = companyRepository.findById(id).orElseThrow();
        return result;
    }


}
