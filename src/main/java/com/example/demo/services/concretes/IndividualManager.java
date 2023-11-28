package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.IndividualService;
import com.example.demo.repositories.IndividualRepository;
import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.example.demo.services.dtos.individual.requests.DeleteIndividualRequest;
import com.example.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IndividualManager implements IndividualService {


    private final IndividualRepository individualRepository;



    public void add(AddIndividualRequest request) {

        Individual individual = new Individual();
        individual.setEmail(request.getEmail());
        individual.setPassword(request.getPassword());
        individual.setFirstName(request.getFirstName());
        individual.setLastName(request.getLastName());
        individual.setNationalId(request.getNationalId());
        individual.setBirthDate(request.getBirthDate());
        individualRepository.save(individual);

    }

    public void update(UpdateIndividualRequest request) {
        Individual individualToUpdate = individualRepository.findById(request.getId()).orElseThrow();
        individualToUpdate.setEmail(request.getEmail());
        individualToUpdate.setPassword(request.getPassword());
        individualToUpdate.setFirstName(request.getFirstName());
        individualToUpdate.setLastName(request.getLastName());
        individualToUpdate.setNationalId(request.getNationalId());
        individualToUpdate.setBirthDate(request.getBirthDate());
        individualRepository.saveAndFlush(individualToUpdate);
    }

    public void delete(DeleteIndividualRequest request) {
        Individual individualToDelete = individualRepository.findById(request.getId()).orElseThrow();
        boolean checkPassword = individualToDelete.getPassword().equals(request.getPassword());
        if (!checkPassword)
            throw new RuntimeException();

        individualRepository.delete(individualToDelete);
    }

    public List<GetListIndividualResponse> getIndividualByBirthDate(int birthYear) {
        return individualRepository.getIndividualByBirthDate(birthYear);
    }

    public List<GetListIndividualResponse> getIndividualByFirstNameDesc() {
        return individualRepository.getIndividualByFirstNameDesc();
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
