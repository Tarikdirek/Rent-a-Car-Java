package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="individual_users")
public class IndividualUser extends User{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="individual_id",referencedColumnName = "individual_id")
    private Individual individual;

}
