package com.example.demo.services.dtos.individual.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListIndividualResponse {

    private String firstName;
    private String lastName;
    private String nationalId;
    private Date birthDate;

}
