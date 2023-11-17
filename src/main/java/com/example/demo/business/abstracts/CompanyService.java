package com.example.demo.business.abstracts;

import com.example.demo.model.Company;

public interface CompanyService {

    void add(Company company);
    void update(Company company);
    void delete(Company company);

    void getAll();
}
