package com.example.demo.services.dtos.card.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCardResponseWithId {

    private int id;
    private int validDate;
    private int cvvNum;
    private String cardNumber;
    private String ownerFullName;
}
