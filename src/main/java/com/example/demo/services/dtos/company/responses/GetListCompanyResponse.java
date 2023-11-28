package com.example.demo.services.dtos.company.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCompanyResponse {


    private String companyName;
    private String webAddress;
    private String phone;
    private String taxNum;

}
