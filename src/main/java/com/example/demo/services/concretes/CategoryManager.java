package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.CategoryService;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.dtos.category.requests.AddCategoryRequest;
import com.example.demo.services.dtos.category.requests.DeleteCategoryRequest;
import com.example.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponse;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponseWithId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {


    public final CategoryRepository categoryRepository;

    public void add(AddCategoryRequest request) {

        if (categoryRepository.existsByCategoryName(request.getName()))
        {
            throw  new RuntimeException("Category already exist");
        }
        Category category = new Category();
        category.setCategoryName(request.getName());
        categoryRepository.save(category);

    }

    public void update(UpdateCategoryRequest request) {

        if (!categoryRepository.existsByCategoryName(request.getName()))
        {
            throw  new RuntimeException("Category does not exist");
        }
        Category categoryToUpdate = categoryRepository.findById(request.getId()).orElseThrow();
        categoryToUpdate.setCategoryName(request.getName());
        categoryRepository.saveAndFlush(categoryToUpdate);
    }

    public void delete(DeleteCategoryRequest request) {
        Category categoryToDelete = categoryRepository.findById(request.getId()).orElseThrow();
        categoryRepository.delete(categoryToDelete);
    }

    public List<GetListCategoryResponse> getAllByDtos(){

        return categoryRepository.findAll().stream()
                .map((category -> new GetListCategoryResponse(category.getCategoryName())))
                .toList();

    }

    public List<GetListCategoryResponse> getByCategoryName(String name) {
        return categoryRepository.findByCategoryNameStartingWith(name).stream()
                .map((categoryName -> new GetListCategoryResponse(categoryName.getCategoryName()))).toList();
    }

    public List<GetListCategoryResponseWithId> getALl() {
        return   categoryRepository.findAll().stream()
                .map(category -> new GetListCategoryResponseWithId(category.getId(), category.getCategoryName())).toList();

    }

    public Category getById(int id) {

        return categoryRepository.findById(id).orElseThrow();



    }
}
