package com.example.demo.business.abstracts;

import com.example.demo.entities.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand);
    void update(Brand brand);
    void delete(int id);

    List<Brand> getALl();
    Brand getById(int id);
}
