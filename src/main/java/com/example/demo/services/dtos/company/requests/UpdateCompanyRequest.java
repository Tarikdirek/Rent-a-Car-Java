package com.example.demo.services.dtos.company.requests;

import lombok.Data;

@Data
public class UpdateCompanyRequest {
    private int id;
    private String email;
    private String password;
    private String taxNum;
    private String companyName;
    private String webAddress;
    private String phone;
}
