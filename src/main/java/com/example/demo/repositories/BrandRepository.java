package com.example.demo.repositories;

import com.example.demo.entities.Brand;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    List<Brand> findByNameStartingWith(String name);

    @Query("SELECT new com.example.demo.services.dtos.brand.responses.GetListBrandResponse(b.name) " +
            "from Brand b where b.name = :name")
    List<GetListBrandResponse>  findByName(String name);

    @Query("SELECT new com.example.demo.services.dtos.brand.responses.GetListBrandResponse(b.name) " +
            "from Brand b where length(b.name)  > :nameLength ")
    List<GetListBrandResponse>  findByNameLength(int nameLength);

}
