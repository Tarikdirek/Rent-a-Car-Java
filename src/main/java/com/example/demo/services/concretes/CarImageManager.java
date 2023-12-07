package com.example.demo.services.concretes;


import com.example.demo.entities.Car;
import com.example.demo.entities.CarImage;
import com.example.demo.repositories.CarImageRepository;
import com.example.demo.services.abstracts.CarImageService;
import com.example.demo.services.abstracts.CarService;
import com.example.demo.services.dtos.carImage.requests.AddCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.DeleteCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.UpdateCarImageRequest;
import com.example.demo.services.dtos.carImage.responses.GetListCarImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarImageManager  implements CarImageService {
    private final CarImageRepository carImageRepository;
    private final CarService carService;

    public void add(AddCarImageRequest request) {

        if (carImageRepository.findByCarId(request.getCarId()).size()>5){
            throw new RuntimeException("A car can not have more than 5 photo");
        }

        CarImage carImageToAdd= new CarImage();
        carImageToAdd.setImagePath(request.getImagePath());
        carImageToAdd.setImageUrl(request.getImageUrl());
        Car car = carService.getById(request.getCarId());
        carImageToAdd.setCar(car);
        carImageRepository.save(carImageToAdd);
    }

    public void delete(DeleteCarImageRequest request) {
        CarImage carImageToUpdate = carImageRepository.findById(request.getId()).orElseThrow();
        carImageRepository.delete(carImageToUpdate);

    }

    public void update(UpdateCarImageRequest request) {

        if (!(carImageRepository.existsByImagePath(request.getImagePath()))) {
            throw new RuntimeException("There is no path variable such like that");
        }

        CarImage carImageToUpdate = carImageRepository.findById(request.getId()).orElseThrow();
        carImageToUpdate.setId(request.getId());
        carImageToUpdate.setImagePath(request.getImagePath());
        carImageToUpdate.setImageUrl(request.getImageUrl());
        Car car = carService.getById(request.getCarId());
        carImageToUpdate.setCar(car);
        carImageRepository.saveAndFlush(carImageToUpdate);
    }

    public List<GetListCarImageResponse> getAll() {
     return carImageRepository.getAll();

    }

    public CarImage getById(int id) {
        return carImageRepository.findById(id).orElseThrow();
    }
}
