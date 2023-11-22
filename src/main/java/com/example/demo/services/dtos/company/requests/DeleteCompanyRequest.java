package com.example.demo.services.dtos.company.requests;

import lombok.Data;

@Data
public class DeleteCompanyRequest {
    private int id;
    private String password;
}
