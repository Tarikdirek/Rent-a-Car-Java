package com.example.demo.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetListCarLimitedResponse {
    private int id;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private String modelName;
}
