package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.example.demo.services.abstracts.CarService;
import com.example.demo.services.dtos.car.requests.AddCarRequest;
import com.example.demo.services.dtos.car.requests.DeleteCarRequest;
import com.example.demo.services.dtos.car.requests.UpdateCarRequest;
import com.example.demo.services.dtos.car.responses.GetListCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {

    public final CarService carService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCarRequest request){
        carService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest request){
        carService.update(request);
    }

    @DeleteMapping("/delete")
    public void  delete(@RequestBody @Valid DeleteCarRequest request){
        carService.delete(request);
    }

    @GetMapping("/getAll")
    public List<GetListCarResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("/getById")
    public Car getById(@RequestParam int id){
        return carService.getById(id);
    }
}
