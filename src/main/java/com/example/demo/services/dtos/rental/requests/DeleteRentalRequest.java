package com.example.demo.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class DeleteRentalRequest {

    @NotNull
    @Positive
    private int id;
}
