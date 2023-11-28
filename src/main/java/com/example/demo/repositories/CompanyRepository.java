package com.example.demo.repositories;

import com.example.demo.entities.Company;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    @Query("select new com.example.demo.services.dtos.company.responses.GetListCompanyResponse(upper(c.companyName) ,c.webAddress,c.taxNum,c.phone) " +
            "from Company c ")
    List<GetListCompanyResponse> getByCompanyNameWithUpperCase();
    @Query("select new com.example.demo.services.dtos.company.responses.GetListCompanyResponse(c.companyName,c.webAddress,c.taxNum,c.phone) " +
            "from Company c where c.phone is not null ")
    List<GetListCompanyResponse> findCompanyWhichPhoneNotNull();

}
