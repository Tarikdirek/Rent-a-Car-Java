package com.example.demo.services.dtos.color.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteColorRequest {

    @NotNull
    @Min(0)
    private int id;
}
