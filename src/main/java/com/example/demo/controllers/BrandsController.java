package com.example.demo.controllers;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.entities.Brand;
import com.example.demo.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    public final BrandService brandService;

    @GetMapping("/getAll")
    public List<Brand> getAll(){
        var result = brandService.getALl();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Brand getById(@PathVariable int id) {
        var result =brandService.getById(id);
        return result;
    }


    @PostMapping("/add")
    public String add(@RequestBody Brand category){

        // individualService.add(individual);
        brandService.add(category);

        return "Brand added";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        brandService.delete(id);
        return "Brand deleted";
    }

    @PutMapping("update")
    public String update(@RequestBody Brand brand){
        brandService.update(brand);
        return "Brand updated";
    }
}
