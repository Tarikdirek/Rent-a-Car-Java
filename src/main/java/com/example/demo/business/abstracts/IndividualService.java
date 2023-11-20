package com.example.demo.business.abstracts;

import com.example.demo.entities.Individual;

import java.util.List;

public interface IndividualService {

    void add(Individual individual);
    void update(int id,Individual individual);
    void delete(int id);

    List<Individual> getALl();
    Individual getById(int id);

}
