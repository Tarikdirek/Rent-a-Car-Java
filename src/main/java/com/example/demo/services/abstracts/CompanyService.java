package com.example.demo.services.abstracts;

import com.example.demo.entities.Company;
import com.example.demo.services.dtos.company.requests.AddCompanyRequest;
import com.example.demo.services.dtos.company.requests.DeleteCompanyRequest;
import com.example.demo.services.dtos.company.requests.UpdateCompanyRequest;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponse;
import org.springframework.data.util.Streamable;

import java.util.List;

public interface CompanyService {

    void add(AddCompanyRequest request);
    void update(UpdateCompanyRequest request);
    void delete(DeleteCompanyRequest request);

    List<GetListCompanyResponse> findCompanyWhichPhoneNotNull();
    List<GetListCompanyResponse> getByCompanyNameWithUpperCase();

    List<Company> getALl();
    Company getById(int id);
}
