package com.example.demo.business.abstracts;

import com.example.demo.entities.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void update(int id,Category category);
    void delete(int id);

    List<Category> getALl();
    Category getById(int id);
}
