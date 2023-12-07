package com.example.demo.services.dtos.category.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListCategoryResponseWithId {
    public int id;
    public String name;
}
