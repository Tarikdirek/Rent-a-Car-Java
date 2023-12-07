package com.example.demo.controllers;

import com.example.demo.entities.Card;
import com.example.demo.services.abstracts.CardService;
import com.example.demo.services.dtos.card.requests.AddCardRequest;
import com.example.demo.services.dtos.card.requests.DeleteCardRequest;
import com.example.demo.services.dtos.card.requests.UpdateCardRequest;
import com.example.demo.services.dtos.card.responses.GetListCardResponseWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cards")
public class CardsController {

    private final CardService cardService;
    @GetMapping("/getAll")
    public List<GetListCardResponseWithId> getAll(){
        return cardService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Card getById(@PathVariable int id){
        return cardService.getById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid AddCardRequest request){
        cardService.add(request);
        return "Card added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteCardRequest request){
        cardService.delete(request);
        return "Card deleted";
    }

    @PutMapping("/updadte")
    public String update(@RequestBody @Valid UpdateCardRequest request){
        cardService.update(request);
        return "Card updated";
    }
}
