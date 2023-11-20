package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    @Autowired
    public BrandRepository brandRepository;

    public void add(Brand brand) {
        brandRepository.save(brand);
    }

    public void update(Brand brand) {
        Brand brandToUpdate = brandRepository.findById(brand.getId()).orElseThrow();
        brandToUpdate.setName(brand.getName());
        brandRepository.saveAndFlush(brandToUpdate);
    }

    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
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
