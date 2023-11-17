package com.example.demo.business.abstracts;

import com.example.demo.model.Individual;

public interface IndividualService {

    void add(Individual individual);
    void update(Individual individual);
    void delete(Individual individual);
    void getAll();
}
