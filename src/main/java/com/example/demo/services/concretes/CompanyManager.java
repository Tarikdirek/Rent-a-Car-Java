package com.example.demo.services.concretes;

import com.example.demo.entities.User;
import com.example.demo.services.abstracts.CompanyService;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.entities.Company;
import com.example.demo.services.dtos.company.requests.AddCompanyRequest;
import com.example.demo.services.dtos.company.requests.DeleteCompanyRequest;
import com.example.demo.services.dtos.company.requests.UpdateCompanyRequest;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponse;
import com.example.demo.services.dtos.company.responses.GetListCompanyResponseWithId;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponseWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {


    private final CompanyRepository companyRepository;

    public void add(AddCompanyRequest request)
    {
        if (companyRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is currently in use");
        }

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
        Company companyToUpdate = companyRepository.findById(request.getId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        companyToUpdate.setEmail(request.getEmail());
        companyToUpdate.setCompanyName(request.getCompanyName());
        companyToUpdate.setTaxNum(request.getTaxNum());
        companyToUpdate.setWebAddress(request.getWebAddress());
        if (request.getPhone() != null) {
            companyToUpdate.setPhone(request.getPhone());
        }else {
            companyToUpdate.setPhone(null);
        }
        companyToUpdate.setPassword(request.getPassword());
        companyRepository.saveAndFlush(companyToUpdate);
    }

    public void delete(DeleteCompanyRequest request) {
        Company companyToDelete = companyRepository.findById(request.getId()).orElseThrow();
        boolean checkPassword =(request.getPassword().equals(companyToDelete.getPassword()));
        if (!checkPassword) {
            throw new RuntimeException("Password is invalid");
        }
        companyRepository.delete(companyToDelete);
    }

    public List<GetListCompanyResponse> findCompanyWhichPhoneNotNull() {
        return companyRepository.findAll().stream().filter(company -> company.getPhone()!=null).map(company ->
                new GetListCompanyResponse(company.getCompanyName(),company.getWebAddress()
                ,company.getPhone(),company.getTaxNum())).toList();
    }

    public List<GetListCompanyResponse> getByCompanyNameWithUpperCase() {
        return companyRepository.findAll().stream().map(company ->
                new GetListCompanyResponse(company.getCompanyName().toUpperCase(),company.getWebAddress()
                        ,company.getPhone(),company.getTaxNum())).toList();
    }


    public List<GetListCompanyResponseWithId> getALl() {
        return  companyRepository.findAll().stream().map(company -> new GetListCompanyResponseWithId(
                company.getId(),company.getEmail(),company.getPassword(),company.getCompanyName(),company.getWebAddress()
                ,company.getPhone(),company.getTaxNum()
        )).toList();

    }

    public GetListCompanyResponseWithId getById(int id) {
        return companyRepository.findAll().stream().filter(company -> company.getId()==id).map(company -> new GetListCompanyResponseWithId(
                company.getId(),company.getEmail(),company.getPassword(),company.getCompanyName(),company.getWebAddress()
                ,company.getPhone(),company.getTaxNum()
        )).findAny().orElseThrow();

    }


}
