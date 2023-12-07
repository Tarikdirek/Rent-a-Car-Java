package com.example.demo.services.abstracts;

import com.example.demo.entities.Car;
import com.example.demo.services.dtos.car.requests.AddCarRequest;
import com.example.demo.services.dtos.car.requests.DeleteCarRequest;
import com.example.demo.services.dtos.car.requests.UpdateCarRequest;
import com.example.demo.services.dtos.car.responses.GetListCarResponse;
import com.example.demo.services.dtos.card.requests.AddCardRequest;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void delete(DeleteCarRequest request);
    void update(UpdateCarRequest request);
    List<GetListCarResponse> getAll();
    Car getById(int id);

}
