package com.example.demo.dataAccess;

import com.example.demo.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualDao extends JpaRepository<Individual,Integer> {
}
