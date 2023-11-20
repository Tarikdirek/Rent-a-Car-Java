package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Column(name="tax_num")
    private String taxNum;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="phone")
    private String phone;




}
