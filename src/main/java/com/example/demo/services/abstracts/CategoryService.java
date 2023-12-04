package com.example.demo.services.abstracts;

import com.example.demo.entities.Category;
import com.example.demo.services.dtos.category.requests.AddCategoryRequest;
import com.example.demo.services.dtos.category.requests.DeleteCategoryRequest;
import com.example.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponse;
import com.example.demo.services.dtos.category.responses.GetListResponseWithId;

import java.util.List;

public interface CategoryService {
    void add(AddCategoryRequest request);
    void update(UpdateCategoryRequest request);
    void delete(DeleteCategoryRequest request);
    List<GetListCategoryResponse> getAllByDtos();
    List<GetListCategoryResponse> getByCategoryName(String name);

    List<GetListResponseWithId> getALl();
    GetListResponseWithId getById(int id);
}
