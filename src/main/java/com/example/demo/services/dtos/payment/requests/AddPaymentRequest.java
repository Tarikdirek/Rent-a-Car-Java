package com.example.demo.services.dtos.payment.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {

    @NotNull
    @Min(0)
    private double paymentFee;

    @NotNull
    @Positive
    private int userId;

    @NotNull
    @Positive
    private int cardId;

}
