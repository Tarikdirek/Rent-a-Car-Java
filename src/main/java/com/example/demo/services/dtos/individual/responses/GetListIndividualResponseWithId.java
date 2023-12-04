package com.example.demo.services.dtos.individual.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListIndividualResponseWithId {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String email;
    private String password;
    private Date birthDate;
}
