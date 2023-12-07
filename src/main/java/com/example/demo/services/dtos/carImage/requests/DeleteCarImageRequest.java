package com.example.demo.services.dtos.carImage.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteCarImageRequest {
    @NotNull
    @Min(value = 0,message = "Id must be greater than 0")
    private int id;
}
