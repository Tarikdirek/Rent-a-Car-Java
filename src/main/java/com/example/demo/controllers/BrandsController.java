package com.example.demo.controllers;

import com.example.demo.services.abstracts.BrandService;
import com.example.demo.entities.Brand;
import com.example.demo.services.dtos.brand.requests.AddBrandRequest;
import com.example.demo.services.dtos.brand.requests.DeleteBrandRequest;
import com.example.demo.services.dtos.brand.requests.UpdateBranRequest;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponse;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {


    public final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetListBrandResponseWithId> getAll(){
        return brandService.getALl();

    }

    @GetMapping("/getById/{id}")
    public Brand getById(@PathVariable int id) {
        return  brandService.getById(id);

    }

    @GetMapping("/getBrandByNameStartingWith")
    public List<GetListBrandResponseWithId> getBrandByNameStartingWith(@RequestParam String name) {
        return brandService.getBrandByName(name);
    }

    @GetMapping("/getBrandDtoName")
    public List<GetListBrandResponse> getBrandDtoName(@RequestParam String name) {
        return brandService.getBrandName(name);
    }

    @GetMapping("/getBrandByNameLength")
    public List<GetListBrandResponseWithId> getBrandNameLength(@RequestParam int nameLength) {
        return brandService.getBrandByNameLength(nameLength);
    }




    @PostMapping("/add")
    public String add(@RequestBody @Valid AddBrandRequest request){
        brandService.add(request);
        return "Brand added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteBrandRequest request){
        brandService.delete(request);
        return "Brand deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdateBranRequest request){
        brandService.update(request);
        return "Brand updated";
    }
}
