package com.example.demo.business.abstracts;

import com.example.demo.entities.Company;

import java.util.List;

public interface CompanyService {

    void add(Company company);
    void update(int id,Company company);
    void delete(int id);

    List<Company> getALl();
    Company getById(int id);
}
