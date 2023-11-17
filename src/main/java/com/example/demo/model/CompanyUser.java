package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="company_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUser extends User{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="company_id",referencedColumnName = "company_id")
    private Company company;
}
