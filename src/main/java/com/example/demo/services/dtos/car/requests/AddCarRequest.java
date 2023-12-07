package com.example.demo.services.dtos.car.requests;

import com.example.demo.entities.Brand;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotNull
    @Min(100)
    private double dailyPrice;

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
    @Length(min = 3)
    private String modelName;

    @NotNull
    @Length(min=6,max=9)
    private String plate;


}
