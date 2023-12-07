package com.example.demo.repositories;

import com.example.demo.entities.Category;
import com.example.demo.services.dtos.category.responses.GetListCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    /* @Query("select new com.example.demo.services.dtos.category.responses.GetListCategoryResponse(c.categoryName) " +
            "from Category c")
    List<GetListCategoryResponse> findAllByDtos();*/


    /* @Query("select new com.example.demo.services.dtos.category.responses.GetListCategoryResponse(c.categoryName) " +
            "from Category c where c.categoryName like concat(:c,'%') ")*/
    List<Category> findByCategoryNameStartingWith(String name);
    boolean existsByCategoryName(String name);
}
