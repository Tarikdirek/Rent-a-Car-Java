package com.example.demo.services.dtos.brand.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateBranRequest {

    @NotNull
    @Positive(message = "Id must be positive number")
    private int id;

    @Length(min = 2,max = 10)
    private String name;
}
