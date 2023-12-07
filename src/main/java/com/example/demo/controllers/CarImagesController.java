package com.example.demo.controllers;

import com.example.demo.entities.CarImage;
import com.example.demo.services.abstracts.CarImageService;
import com.example.demo.services.dtos.carImage.requests.AddCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.DeleteCarImageRequest;
import com.example.demo.services.dtos.carImage.requests.UpdateCarImageRequest;
import com.example.demo.services.dtos.carImage.responses.GetListCarImageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carImages")
public class CarImagesController {

    private final CarImageService carImageService;

    @GetMapping("getAll")
    public List<GetListCarImageResponse> getAll(){
       return carImageService.getAll();
    }

    @GetMapping("getById")
    public CarImage getById(@RequestParam int id){
        return carImageService.getById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid AddCarImageRequest request){
        carImageService.add(request);
        return "Image added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteCarImageRequest request){
        carImageService.delete(request);
        return "Image deleted";
    }
    @PutMapping("/update")
    public String update (@RequestBody @Valid UpdateCarImageRequest request){
        carImageService.update(request);
        return "Image update";
    }
}
