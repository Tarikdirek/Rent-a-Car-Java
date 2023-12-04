package com.example.demo.services.concretes;

import com.example.demo.entities.Car;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.abstracts.CarService;
import org.springframework.stereotype.Service;


@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void add(Car car) {
        carRepository.save(car);
    }
}
