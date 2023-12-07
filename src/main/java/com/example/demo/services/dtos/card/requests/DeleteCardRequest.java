package com.example.demo.services.dtos.card.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DeleteCardRequest {

    @NotNull
    @Positive(message = "Id must be positive number")
    private int id;
}
