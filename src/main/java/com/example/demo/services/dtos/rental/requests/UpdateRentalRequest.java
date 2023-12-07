package com.example.demo.services.dtos.rental.requests;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class UpdateRentalRequest {

    @NotNull
    @Positive
    private int id;

    @NotNull
    @FutureOrPresent(message = "Rent date must be present or future date")
    private LocalDate rentDate;

    @NotNull
    private LocalDate returnDate;

    @NotNull
    @Positive
    private int userId;

    @NotNull
    @Min(0)
    private int carId;
}
