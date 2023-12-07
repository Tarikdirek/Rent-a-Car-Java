package com.example.demo.services.dtos.individual.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class AddIndividualRequest {

    @NotNull(message = "email can not be null")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "password can not be null")
    @Length(min = 5)
    private String password;

    @NotNull(message = "firstName can not be null")
    @Length(min = 3)
    private String firstName;

    @NotNull(message = "lastName can not be null")
    @Length(min = 2)
    private String lastName;

    @NotNull(message = "nationalId can not be null")
    @Length(min = 11,max = 11)
    private String nationalId;

    @NotNull(message = "birthDate can not be null")
    @PastOrPresent(message = "Birth date can not be future date")
    private Date birthDate;
}
