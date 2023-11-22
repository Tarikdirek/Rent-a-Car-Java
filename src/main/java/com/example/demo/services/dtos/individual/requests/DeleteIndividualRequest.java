package com.example.demo.services.dtos.individual.requests;

import lombok.Data;

@Data
public class DeleteIndividualRequest {
    private int id;
    private String password;
}
