package com.example.demo.repositories;

import com.example.demo.entities.Rental;
import com.example.demo.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

    boolean existsById(int id);

}
