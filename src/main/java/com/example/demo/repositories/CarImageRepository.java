package com.example.demo.repositories;

import com.example.demo.entities.CarImage;
import com.example.demo.services.dtos.carImage.responses.GetListCarImageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarImageRepository extends JpaRepository<CarImage,Integer> {

    @Query("select new com.example.demo.services.dtos.carImage.responses.GetListCarImageResponse(ci.id,ci.imagePath,ci.imageUrl,new com.example.demo.services.dtos.car.responses.GetListCarLimitedResponse(c.id,c.dailyPrice,c.modelYear,c.plate,c.modelName)) from CarImage ci inner join ci.car c")
    List<GetListCarImageResponse> getAll();

    boolean existsByImagePath(String path );
    List<CarImage> findByCarId(int id);
}
