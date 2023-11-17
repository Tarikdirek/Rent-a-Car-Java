package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.IndividualService;
import com.example.demo.dataAccess.IndividualDao;
import com.example.demo.model.Individual;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class IndividualManager implements IndividualService {

    @Autowired
    private IndividualDao _individualDao;

    public IndividualManager(IndividualDao _individualDao) {
        this._individualDao = _individualDao;
    }



    public void add(Individual individual) {
        _individualDao.save(individual);
    }

    public void update(Individual individual) {
        _individualDao.saveAndFlush(individual);
    }

    public void delete(Individual individual) {
        _individualDao.delete(individual);
    }

    public void getAll() {
        _individualDao.findAll();
    }
}
