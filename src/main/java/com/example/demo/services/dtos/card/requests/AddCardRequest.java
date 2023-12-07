package com.example.demo.services.dtos.card.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCardRequest {

    @NotNull
    @Min(value = 2023,message = "Card must be valid at least 2023")
    private int validDate;

    @NotNull
    @Max(4)
    private int cvvNum;

    @NotNull
    @Length(min = 16,max = 16,message = "Card number must be valid")
    private String cardNumber;

    @NotNull(message = "Name field must not be empty")
    @Length(min = 5)
    private String ownerFullName;
}
