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
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "status")
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "color_id")
    private Color color;


    @ManyToOne()
    @JoinColumn(name ="category_id")
    private Category category;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<CarImage> carImageList;



}
