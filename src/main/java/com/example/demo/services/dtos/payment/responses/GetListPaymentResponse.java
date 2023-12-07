package com.example.demo.services.dtos.payment.responses;

import com.example.demo.services.dtos.card.responses.GetListCardResponseWithId;
import com.example.demo.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class GetListPaymentResponse {
    private int id;
    private double paymentFee;
    private GetListUserResponse user;
    private GetListCardResponseWithId card;
}
