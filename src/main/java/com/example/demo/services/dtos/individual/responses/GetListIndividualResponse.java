package com.example.demo.services.dtos.individual.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListIndividualResponse {

    private String firstName;
    private String lastName;
    private String nationalId;
    private int birthDate;
}
