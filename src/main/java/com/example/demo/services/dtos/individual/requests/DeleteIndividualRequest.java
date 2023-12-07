package com.example.demo.services.dtos.individual.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class DeleteIndividualRequest {

    @NotNull
    @Positive
    private int id;

    @NotNull
    @Length(min = 5)
    private String password;
}
