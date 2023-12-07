package com.example.demo.repositories;

import com.example.demo.entities.Car;
import com.example.demo.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("select new com.example.demo.services.dtos.car.responses.GetListCarResponse(c.id,c.dailyPrice,c.modelYear,c.plate,c.modelName," +
            "new com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId(b.id,b.name), " +
            "new com.example.demo.services.dtos.color.responses.GetListColorResponseWithId(co.id,co.name)," +
            "new com.example.demo.services.dtos.category.responses.GetListCategoryResponseWithId(cat.id,cat.categoryName)) " +
            "from Car c " +
            "INNER JOIN c.brand b " +
            "INNER JOIN c.color co " +
            "inner join c.category cat")
    List<GetListCarResponse> getAll();

    @Query("select new com.example.demo.services.dtos.car.responses.GetListCarResponse(c.id,c.dailyPrice,c.modelYear,c.plate,c.modelName," +
            "new com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId(b.id,b.name), " +
            "new com.example.demo.services.dtos.color.responses.GetListColorResponseWithId(co.id,co.name)," +
            "new com.example.demo.services.dtos.category.responses.GetListCategoryResponseWithId(cat.id,cat.categoryName)) " +
            "from Car c " +
            "INNER JOIN c.brand b " +
            "INNER JOIN c.color co " +
            "inner join c.category cat where c.id = :id")
    GetListCarResponse getCarById(int id);

    boolean existsByPlate(String plate);


}
