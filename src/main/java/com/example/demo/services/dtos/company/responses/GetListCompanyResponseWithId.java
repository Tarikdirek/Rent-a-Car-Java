package com.example.demo.services.dtos.company.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCompanyResponseWithId {

    private int id;
    private String email;
    private String password;
    private String companyName;
    private String webAddress;
    private String phone;
    private String taxNum;
}
