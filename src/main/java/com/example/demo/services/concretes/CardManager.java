package com.example.demo.services.concretes;

import com.example.demo.entities.Card;
import com.example.demo.repositories.CardRepository;
import com.example.demo.services.abstracts.CardService;
import com.example.demo.services.dtos.brand.responses.GetListBrandResponseWithId;
import com.example.demo.services.dtos.card.requests.AddCardRequest;
import com.example.demo.services.dtos.card.requests.DeleteCardRequest;
import com.example.demo.services.dtos.card.requests.UpdateCardRequest;
import com.example.demo.services.dtos.card.responses.GetListCardResponseWithId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardManager implements CardService {

    private final CardRepository cardRepository;
    public void add(AddCardRequest request) {
        Card carToAdd = new Card();
        carToAdd.setOwnerFullName(request.getOwnerFullName());
        carToAdd.setCardNumber(request.getCardNumber());
        carToAdd.setValidDate(request.getValidDate());
        carToAdd.setCvvNum(request.getCvvNum());
        cardRepository.save(carToAdd);
    }

    public void delete(DeleteCardRequest request) {
        Card cardToDelete = cardRepository.findById(request.getId()).orElseThrow();
        cardRepository.delete(cardToDelete);

    }

    public void update(UpdateCardRequest request) {
        Card cardToUpdate = cardRepository.findById(request.getId()).orElseThrow();
        cardToUpdate.setOwnerFullName(request.getOwnerFullName());
        cardToUpdate.setCardNumber(request.getCardNumber());
        cardToUpdate.setValidDate(request.getValidDate());
        cardToUpdate.setCvvNum(request.getCvvNum());
        cardRepository.saveAndFlush(cardToUpdate);


    }

    public List<GetListCardResponseWithId> getAll() {
        return cardRepository.findAll().stream().map(card -> new GetListCardResponseWithId(card.getId(),card.getValidDate(),card.getCvvNum(),
        card.getCardNumber(),card.getOwnerFullName())).toList();
    }

    public Card getById(int id) {
        return cardRepository.findById(id).orElseThrow();
    }
}
