package com.example.demo.services.dtos.rental.responses;

import com.example.demo.services.dtos.car.responses.GetListCarResponse;
import com.example.demo.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListRentalResponse {
    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int carId;
    private int userId;
}
