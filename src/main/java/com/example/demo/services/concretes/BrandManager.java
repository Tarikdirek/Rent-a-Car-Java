package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.BrandService;
import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.dtos.brand.requests.AddBrandRequest;
import com.example.demo.services.dtos.brand.requests.DeleteBrandRequest;
import com.example.demo.services.dtos.brand.requests.UpdateBranRequest;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {


    public BrandRepository brandRepository;

    public void add(AddBrandRequest request) {

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    public void update(UpdateBranRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();
        brandToUpdate.setName(request.getName());
        brandRepository.saveAndFlush(brandToUpdate);
    }

    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    public List<Brand> getBrandByName(String name) {

        return brandRepository.findByNameStartingWith(name);
    }

    public List<GetListBrandResponse> getBrandName(String name) {
        return brandRepository.findByName(name);
    }

    public List<GetListBrandResponse> getBrandByNameLength(int nameLength) {

        return brandRepository.findByNameLength(nameLength);
    }


    public List<Brand> getALl() {
        var result = brandRepository.findAll();
        return result;
    }

    public Brand getById(int id) {
        var result = brandRepository.findById(id).orElseThrow();
        return result;
    }
}
