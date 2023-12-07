package com.example.demo.services.dtos.carImage.responses;

import com.example.demo.services.dtos.car.responses.GetListCarLimitedResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCarImageResponse {
    private int id;
    private String imagePath;
    private String imageUrl;
    private GetListCarLimitedResponse car;

}
