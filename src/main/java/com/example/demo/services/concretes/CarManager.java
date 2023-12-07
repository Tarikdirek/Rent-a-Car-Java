package com.example.demo.services.concretes;

import com.example.demo.entities.Brand;
import com.example.demo.entities.Car;
import com.example.demo.entities.Category;
import com.example.demo.entities.Color;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.abstracts.BrandService;
import com.example.demo.services.abstracts.CarService;
import com.example.demo.services.abstracts.CategoryService;
import com.example.demo.services.abstracts.ColorService;
import com.example.demo.services.dtos.car.requests.AddCarRequest;
import com.example.demo.services.dtos.car.requests.DeleteCarRequest;
import com.example.demo.services.dtos.car.requests.UpdateCarRequest;
import com.example.demo.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final CategoryService categoryService;
    private final ColorService colorService;
    private final BrandService brandService;
    public void add(AddCarRequest request) {

        if (carRepository.existsByPlate(request.getPlate())) {
            throw new RuntimeException("There is already a car have this plate");
        }

        Car carToAdd = new Car();
        carToAdd.setDailyPrice(request.getDailyPrice());
        carToAdd.setStatus("Available");
        carToAdd.setModelName(request.getModelName());
        carToAdd.setModelYear(request.getModelYear());
        carToAdd.setPlate(request.getPlate());
        Category category = categoryService.getById(request.getCategoryId());
        carToAdd.setCategory(category);
        Color color = colorService.getById(request.getColorId());
        carToAdd.setColor(color);
        Brand brand = brandService.getById(request.getBrandId());
        carToAdd.setBrand(brand);
        carRepository.save(carToAdd);

    }

    public void delete(DeleteCarRequest request)
    {
        Car carToDelete = carRepository.findAll().stream().filter(car -> car.getId()== request.getId()).findAny().orElseThrow();
        carRepository.delete(carToDelete);
    }

    public void update(UpdateCarRequest request)
    {
        if (carRepository.findById(request.getId()).isEmpty()) {
                throw new RuntimeException("No car found");
        }

        Car carToUpdate = carRepository.findById(request.getId()).orElseThrow();
        carToUpdate.setModelName(request.getModelName());
        carToUpdate.setModelYear(request.getModelYear());
        carToUpdate.setDailyPrice(request.getDailyPrice());
        carToUpdate.setStatus(request.getStatus());
        carToUpdate.setPlate(request.getPlate());
        Brand brand = brandService.getById(request.getBrandId());
        carToUpdate.setBrand(brand);
        Color color = colorService.getById(request.getColorId());
        carToUpdate.setColor(color);
        Category category = categoryService.getById(request.getCategoryId());
        carToUpdate.setCategory(category);
        carRepository.saveAndFlush(carToUpdate);

    }

    public List<GetListCarResponse> getAll() {
        return carRepository.getAll();
    }

    public Car getById(int id) {
        return  carRepository.findById(id).orElseThrow();

    }
}
