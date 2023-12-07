package com.example.demo.services.dtos.individual.requests;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class UpdateIndividualRequest {

    @NotNull
    @Positive
    private int id;

    @NotEmpty
    @Email(message = "Email must be valid")
    private String email;

    @NotNull
    @Length(min = 5)
    private String password;

    @NotNull
    @Length(min = 3)
    private String firstName;

    @NotNull
    @Length(min = 2)
    private String lastName;

    @NotNull
    @Length(min = 11,max = 11)
    private String nationalId;

    @NotNull
    @PastOrPresent(message = "Birth date can not be future date")
    private Date birthDate;
}
