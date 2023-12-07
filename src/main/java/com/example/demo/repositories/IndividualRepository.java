package com.example.demo.repositories;

import com.example.demo.entities.Individual;
import com.example.demo.services.dtos.individual.responses.GetListIndividualResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IndividualRepository extends JpaRepository<Individual,Integer> {

    @Query("select new com.example.demo.services.dtos.individual.responses.GetListIndividualResponse(i.firstName,i.lastName,i.nationalId,i.birthDate) " +
            "from Individual i where  year(i.birthDate) = :birthYear")
    List<GetListIndividualResponse> getIndividualByBirthDate(int birthYear);

    /* @Query("select new com.example.demo.services.dtos.individual.responses.GetListIndividualResponse(i.firstName,i.lastName,i.nationalId,i.email,i.password,i.birthDate) " +
            "from Individual i order by i.firstName desc ")
    List<GetListIndividualResponse> getIndividualByFirstNameDesc(); */

    boolean existsByNationalId(String id);
    boolean existsByEmail(String email);
}
