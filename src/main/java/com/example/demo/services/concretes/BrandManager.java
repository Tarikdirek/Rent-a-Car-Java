package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.BrandService;
import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import com.example.demo.services.dtos.brand.requests.AddBrandRequest;
import com.example.demo.services.dtos.brand.requests.DeleteBrandRequest;
import com.example.demo.services.dtos.brand.requests.UpdateBranRequest;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponse;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {


    public BrandRepository brandRepository;

    public void add(AddBrandRequest request) {

        if (brandRepository.existsBrandByName(request.getName())){
            throw new RuntimeException("Brand already exist");
        }

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    public void update(UpdateBranRequest request) {

        if (!(brandRepository.existsBrandByName(request.getName()))){
            throw new RuntimeException("Brand not exist");
        }

        Brand brandToUpdate = brandRepository.findById(request.getId()).orElseThrow();
        brandToUpdate.setName(request.getName());
        brandRepository.saveAndFlush(brandToUpdate);
    }

    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    public List<GetListBrandResponseWithId> getBrandByName(String name) {

        return brandRepository.findByNameStartingWith(name).stream()
                .map((x)-> new GetListBrandResponseWithId(x.getId(), x.getName())).toList();
    }

    public List<GetListBrandResponse> getBrandName(String name) {
        return brandRepository.findByName(name);
    }

    public List<GetListBrandResponseWithId> getBrandByNameLength(int nameLength) {

        return brandRepository.findAll().stream().filter((brand) -> brand.getName().length() >= nameLength )
                .map((brand -> new GetListBrandResponseWithId(brand.getId(), brand.getName()))).toList();
    }


    public List<GetListBrandResponseWithId> getALl() {
        return brandRepository.findAll().stream()
                .map(brand -> new GetListBrandResponseWithId(brand.getId(), brand.getName())).toList();

    }

    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }
}
