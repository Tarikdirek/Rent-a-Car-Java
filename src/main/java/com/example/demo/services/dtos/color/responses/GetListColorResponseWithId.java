package com.example.demo.services.dtos.color.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetListColorResponseWithId {
    private int id;
    private String name;
}
