package com.example.demo.services.dtos.category.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddCategoryRequest {
    @NotNull(message = "Name can not be empty")
    @Length(min = 3)
    private String name;
}
