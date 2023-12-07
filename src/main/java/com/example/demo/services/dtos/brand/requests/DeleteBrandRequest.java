package com.example.demo.services.dtos.brand.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DeleteBrandRequest {
    @NotNull
    @Positive(message = "Id must be positive number")
    private int id;
}
