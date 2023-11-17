package com.example.demo.dataAccess;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Integer> {
}
