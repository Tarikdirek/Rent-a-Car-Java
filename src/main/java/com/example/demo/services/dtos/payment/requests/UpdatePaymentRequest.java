package com.example.demo.services.dtos.payment.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdatePaymentRequest {

    @NotNull
    @Positive
    private int id;

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
