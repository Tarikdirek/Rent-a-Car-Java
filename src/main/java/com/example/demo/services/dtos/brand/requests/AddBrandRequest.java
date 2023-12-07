package com.example.demo.services.dtos.brand.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddBrandRequest {

    @NotNull
    @Length(min = 2)
    private String name;
}
