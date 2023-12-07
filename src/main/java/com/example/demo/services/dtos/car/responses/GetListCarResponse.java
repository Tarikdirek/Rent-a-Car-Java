package com.example.demo.services.dtos.car.responses;


import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponseWithId;
import com.example.demo.services.dtos.color.responses.GetListColorResponseWithId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetListCarResponse {
    private int id;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private String modelName;

    private GetListBrandResponseWithId brand;
    private GetListColorResponseWithId color;
    private GetListCategoryResponseWithId category;
}
