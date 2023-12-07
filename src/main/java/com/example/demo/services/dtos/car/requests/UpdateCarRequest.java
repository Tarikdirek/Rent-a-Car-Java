package com.example.demo.services.dtos.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class UpdateCarRequest {
    @NotNull
    @Positive
    private int id;

    @NotNull
    @Positive
    @Min(2018)
    private int modelYear;

    @NotNull
    @Positive
    private int brandId;

    @NotNull
    @Positive
    private int colorId;

    @NotNull
    @Positive
    private int categoryId;

    @NotNull
    @Min(100)
    private double dailyPrice;

    @NotNull
    @Length(min = 3)
    private String modelName;

    @NotNull
    @Length(min = 5)
    private String status;

    @NotNull
    @Length(min=6,max=9)
    private String plate;
}
