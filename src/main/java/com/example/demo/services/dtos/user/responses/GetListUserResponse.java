package com.example.demo.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetListUserResponse {
    private int id;
    private String email;
    private String password;
}
