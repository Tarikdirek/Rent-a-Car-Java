package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name="tax_num")
    private String taxNum;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="phone")
    private String phone;




}
