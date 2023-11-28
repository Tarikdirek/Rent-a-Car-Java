package com.example.demo.controllers;

import com.example.demo.services.abstracts.CategoryService;
import com.example.demo.entities.Category;
import com.example.demo.services.dtos.category.requests.AddCategoryRequest;
import com.example.demo.services.dtos.category.requests.DeleteCategoryRequest;
import com.example.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {

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

    @GetMapping("/getAllByDtos")
    public List<GetListCategoryResponse> getAllByDtos(){
        return categoryService.getAllByDtos();
    }

    @GetMapping("/getAllByCharacter")
    public List<GetListCategoryResponse> getByFirstCharacter(@RequestParam char character) {
        return categoryService.getByFirstCharacter(character);
    }

    @PostMapping("/add")
    public String add(@RequestBody AddCategoryRequest request){
        categoryService.add(request);
        return "Category added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteCategoryRequest request){
        categoryService.delete(request);
        return "Category deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody UpdateCategoryRequest request){
        categoryService.update(request);
        return "Category updated";
    }
}
