package com.example.demo.repositories;

import com.example.demo.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage,Integer> {
}