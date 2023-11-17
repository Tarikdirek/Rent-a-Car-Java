package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.dataAccess.CompanyDao;
import com.example.demo.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {

    @Autowired
    private CompanyDao _companyDao;

    public void add(Company company) {
        _companyDao.save(company);
    }

    public void update(Company company) {
        _companyDao.saveAndFlush(company);
    }

    public void delete(Company company) {
        _companyDao.delete(company);
    }

    public void getAll() {
        _companyDao.findAll();
    }
}
