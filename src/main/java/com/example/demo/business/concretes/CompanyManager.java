package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.entities.Individual;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void add(Company company) {
        companyRepository.save(company);
    }

    public void update(int id,Company company) {
        Company companyToUpdate = companyRepository.findById(id).orElseThrow();
        companyToUpdate.setEmail(company.getEmail());
        companyToUpdate.setCompanyName(company.getCompanyName());
        companyToUpdate.setTaxNum(company.getTaxNum());
        companyToUpdate.setWebAddress(company.getWebAddress());
        companyToUpdate.setPhone(company.getPhone());
        companyToUpdate.setPassword(company.getPassword());
        companyRepository.saveAndFlush(companyToUpdate);
    }

    public void delete(int id) {
        Company companyToDelete = companyRepository.findById(id).orElseThrow();
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
