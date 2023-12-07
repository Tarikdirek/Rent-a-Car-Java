package com.example.demo.services.dtos.color.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateColorRequest {

    @NotNull
    @Min(0)
    private int id;

    @NotNull(message = "Color name can not be empty")
    @Length(min = 3)
    private String name;
}
