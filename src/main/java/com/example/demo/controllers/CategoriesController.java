package com.example.demo.controllers;

import com.example.demo.business.abstracts.CategoryService;
import com.example.demo.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        var result = categoryService.getALl();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Category getById(@PathVariable int id) {
        var result =categoryService.getById(id);
        return result;
    }


    @PostMapping("/add")
    public String add(@RequestBody Category category){

        // individualService.add(individual);
        categoryService.add(category);

        return "Category added";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        categoryService.delete(id);
        return "Category deleted";
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable int id,@RequestBody Category category){
        categoryService.update(id,category);
        return "Category updated";
    }
}
