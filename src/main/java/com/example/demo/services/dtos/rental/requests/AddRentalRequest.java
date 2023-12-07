package com.example.demo.services.dtos.rental.requests;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddRentalRequest {
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
