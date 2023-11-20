package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.IndividualService;
import com.example.demo.repositories.IndividualRepository;
import com.example.demo.entities.Individual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndividualManager implements IndividualService {


    private final IndividualRepository individualRepository;


    @Autowired
    public IndividualManager(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;

    }


    public void add(Individual individual) {
        individualRepository.save(individual);

    }

    public void update(int id, Individual individual) {
        Individual individualToUpdate = individualRepository.findById(id).orElseThrow();
        individualToUpdate.setEmail(individual.getEmail());
        individualToUpdate.setPassword(individual.getPassword());
        individualToUpdate.setFirstName(individual.getFirstName());
        individualToUpdate.setLastName(individual.getLastName());
        individualToUpdate.setNationalId(individual.getNationalId());
        individualToUpdate.setBirthDate(individual.getBirthDate());
        individualRepository.saveAndFlush(individualToUpdate);
    }

    public void delete(int id) {
        Individual individualToDelete = individualRepository.findById(id).orElseThrow();
        individualRepository.delete(individualToDelete);
    }

    public List<Individual> getALl() {
        var result = individualRepository.findAll();
        return result;
    }

    public Individual getById(int id) {
        var result = individualRepository.findById(id).orElseThrow();
        return result;
    }


}
