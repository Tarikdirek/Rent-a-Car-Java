package com.example.demo.services.abstracts;

import com.example.demo.entities.Category;
import com.example.demo.services.dtos.category.requests.AddCategoryRequest;
import com.example.demo.services.dtos.category.requests.DeleteCategoryRequest;
import com.example.demo.services.dtos.category.requests.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    void add(AddCategoryRequest request);
    void update(UpdateCategoryRequest request);
    void delete(DeleteCategoryRequest request);

    List<Category> getALl();
    Category getById(int id);
}