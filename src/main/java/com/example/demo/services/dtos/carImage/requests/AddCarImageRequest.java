package com.example.demo.services.dtos.carImage.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class AddCarImageRequest {
    @NotNull
    @Positive
    private int carId;

    @NotNull(message = "ImageUrl field must not be empty")
    @Length(min = 7)
    private String imageUrl;

    @NotEmpty(message = "ImagePath field must not be empty")
    @Length(min = 10,message = "ImagePath length must be at least 10 character")
    private String imagePath;

}
