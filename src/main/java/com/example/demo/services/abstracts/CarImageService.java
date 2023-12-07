package com.example.demo.services.abstracts;

import com.example.demo.entities.CarImage;
import com.example.demo.services.dtos.carImage.requests.AddCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.DeleteCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.UpdateCarImageRequest;
import com.example.demo.services.dtos.carImage.responses.GetListCarImageResponse;

import java.util.List;

public interface CarImageService {
    void add(AddCarImageRequest request);
    void delete(DeleteCarImageRequest request);
    void  update(UpdateCarImageRequest request);
    List<GetListCarImageResponse> getAll();
    CarImage getById(int id);
}
