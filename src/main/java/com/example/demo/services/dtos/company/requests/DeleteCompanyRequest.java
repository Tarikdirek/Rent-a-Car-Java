package com.example.demo.services.dtos.company.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class DeleteCompanyRequest {

    @NotNull
    @Positive
    private int id;

    @NotEmpty
    @Length(min = 5)
    private String password;
}
