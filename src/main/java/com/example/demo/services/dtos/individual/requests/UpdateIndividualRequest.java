package com.example.demo.services.dtos.individual.requests;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateIndividualRequest {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalId;
    private Date birthDate;
}
