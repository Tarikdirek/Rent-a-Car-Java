package com.example.demo.services.dtos.category.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteCategoryRequest {

    @NotNull
    @Min(0)
    private int id;
}
