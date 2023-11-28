package com.example.demo.repositories;

import com.example.demo.entities.Color;
import com.example.demo.services.dtos.color.responses.GetListColorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Integer> {

    Color findColorByName(String name);


    @Query("select new com.example.demo.services.dtos.color.responses.GetListColorResponse(c.name) from Color c " +
            "order by c.name ")
    List<GetListColorResponse> getColorByOrder();


}
