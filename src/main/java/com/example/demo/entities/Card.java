package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "valid_date")
    private int validDate;

    @Column(name="cvv_num")
    private int cvvNum;

    @Column(name = "owner_full_name")
    private String cardNumber;

    @Column(name = "card_number")
    private String ownerFullName;

    @OneToMany(mappedBy = "card")
    @JsonIgnore
    private List<Payment> payments;

}
