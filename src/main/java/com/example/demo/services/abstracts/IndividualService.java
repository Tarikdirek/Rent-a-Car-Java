package com.example.demo.services.abstracts;

import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.example.demo.services.dtos.individual.requests.DeleteIndividualRequest;
import com.example.demo.services.dtos.individual.requests.UpdateIndividualRequest;

import java.util.List;

public interface IndividualService {

    void add(AddIndividualRequest request);
    void update(UpdateIndividualRequest request);
    void delete(DeleteIndividualRequest request);

    List<Individual> getALl();
    Individual getById(int id);

}
