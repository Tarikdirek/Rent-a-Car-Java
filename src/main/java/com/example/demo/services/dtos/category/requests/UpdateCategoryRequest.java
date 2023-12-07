package com.example.demo.services.dtos.category.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCategoryRequest {
    @NotEmpty
    @Positive
    private int id;

    @NotNull(message = "Name can not be empty")
    @Length(min = 3)
    private String name;
}
