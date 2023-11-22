package com.example.demo.services.dtos.company.requests;

import lombok.Data;

@Data
public class AddCompanyRequest {
    private String email;
    private String password;
    private String taxNum;
    private String companyName;
    private String webAddress;
    private String phone;
}
