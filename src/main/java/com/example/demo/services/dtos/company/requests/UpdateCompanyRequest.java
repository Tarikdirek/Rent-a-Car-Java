package com.example.demo.services.dtos.company.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateCompanyRequest {

    @NotNull
    @Positive
    private int id;

    @NotEmpty
    @Email(message = "Email must be a valid value")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    @Length(min = 8)
    private String taxNum;

    @NotEmpty
    @Length(min = 5)
    private String companyName;

    @NotNull
    @Length(min = 6)
    private String webAddress;

    @NotEmpty
    @Length(min = 8)
    private String phone;
}
