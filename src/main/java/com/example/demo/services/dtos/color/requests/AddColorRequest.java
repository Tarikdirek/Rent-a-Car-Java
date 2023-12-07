package com.example.demo.services.dtos.color.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddColorRequest {

    @NotNull(message = "Color name can not be empty")
    @Length(min = 3)
    private String name;
}
