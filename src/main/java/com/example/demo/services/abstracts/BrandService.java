package com.example.demo.services.abstracts;

import com.example.demo.entities.Brand;
import com.example.demo.services.dtos.brand.requests.AddBrandRequest;
import com.example.demo.services.dtos.brand.requests.DeleteBrandRequest;
import com.example.demo.services.dtos.brand.requests.UpdateBranRequest;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponse;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;

import java.util.List;

public interface BrandService {

    void add(AddBrandRequest request);
    void update(UpdateBranRequest request);
    void delete(DeleteBrandRequest request);
    List<GetListBrandResponseWithId> getBrandByName(String name);
    List<GetListBrandResponse> getBrandName(String name);
    List<GetListBrandResponseWithId> getBrandByNameLength(int name);
    List<Brand> getALl();
    Brand getById(int id);




}
