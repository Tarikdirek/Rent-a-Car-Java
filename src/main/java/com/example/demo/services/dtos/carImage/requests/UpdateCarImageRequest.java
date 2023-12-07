package com.example.demo.services.dtos.carImage.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class UpdateCarImageRequest {

    @NotNull
    @Positive
    private int id;

    @NotNull
    @Min(0)
    private int carId;

    @NotEmpty(message = "ImagePath field must not be empty")
    @Length(min = 10)
    private String imagePath;

    @NotEmpty(message = "ImageUrl field must not be empty")
    @Length(min = 7)
    private String imageUrl;

}
