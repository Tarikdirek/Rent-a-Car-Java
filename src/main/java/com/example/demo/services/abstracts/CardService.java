package com.example.demo.services.abstracts;

import com.example.demo.entities.Card;
import com.example.demo.services.dtos.card.requests.AddCardRequest;
import com.example.demo.services.dtos.card.requests.DeleteCardRequest;
import com.example.demo.services.dtos.card.requests.UpdateCardRequest;
import com.example.demo.services.dtos.card.responses.GetListCardResponseWithId;

import java.util.List;

public interface CardService {
    void add(AddCardRequest request);
    void delete(DeleteCardRequest request);
    void update(UpdateCardRequest request);

    List<GetListCardResponseWithId> getAll();
    Card getById(int id);


}
