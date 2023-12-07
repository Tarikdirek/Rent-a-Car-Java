package com.example.demo.services.concretes;

import com.example.demo.services.abstracts.IndividualService;
import com.example.demo.repositories.IndividualRepository;
import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.example.demo.services.dtos.individual.requests.DeleteIndividualRequest;
import com.example.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponse;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponseWithId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class IndividualManager implements IndividualService {


    private final IndividualRepository individualRepository;



    public void add(AddIndividualRequest request) {

        if (individualRepository.existsByNationalId(request.getNationalId())) {
            throw new RuntimeException("National id is already in use");
        }

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
        if (individualRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User not found");
        }
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
        var result= individualRepository.getIndividualByBirthDate(birthYear);
        return result;
    }

    public List<GetListIndividualResponse> getIndividualByFirstNameDesc() {
        return individualRepository.findAll().stream().sorted(Comparator.comparing(Individual::getFirstName).reversed())
                .map(individual -> new GetListIndividualResponse(
                individual.getFirstName(),individual.getLastName(),individual.getNationalId(),individual.getBirthDate())).toList();
    }

    public List<GetListIndividualResponseWithId> getALl() {
        return   individualRepository.findAll().stream().map(individual -> new GetListIndividualResponseWithId(individual.getId(),
                individual.getFirstName(),individual.getLastName(),individual.getNationalId(),individual.getEmail(),
                individual.getPassword(),individual.getBirthDate())).toList();

    }

    public Individual getById(int id) {
        return  individualRepository.findById(id).orElseThrow();

    }


}
