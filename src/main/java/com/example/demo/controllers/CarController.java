package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.example.demo.services.abstracts.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarController {

    public final CarService carService;

    @PostMapping("/add")
    public void add(Car car){
        carService.add(car);
    }
}
