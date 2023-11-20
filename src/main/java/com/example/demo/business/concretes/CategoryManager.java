package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.CategoryService;
import com.example.demo.entities.Category;
import com.example.demo.entities.Individual;
import com.example.demo.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    @Autowired
    public final CategoryRepository categoryRepository;

    public void add(Category category) {
        categoryRepository.save(category);

    }

    public void update(int id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        categoryToUpdate.setCategoryName(category.getCategoryName());
        categoryRepository.saveAndFlush(categoryToUpdate);
    }

    public void delete(int id) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(categoryToDelete);
    }

    public List<Category> getALl() {
        var result = categoryRepository.findAll();
        return result;
    }

    public Category getById(int id) {
        var result = categoryRepository.findById(id).orElseThrow();
        return result;
    }
}
