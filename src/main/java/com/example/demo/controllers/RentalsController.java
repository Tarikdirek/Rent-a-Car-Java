package com.example.demo.controllers;

import com.example.demo.entities.Rental;
import com.example.demo.services.abstracts.RentalService;
import com.example.demo.services.dtos.rental.requests.AddRentalRequest;
import com.example.demo.services.dtos.rental.requests.DeleteRentalRequest;
import com.example.demo.services.dtos.rental.requests.UpdateRentalRequest;
import com.example.demo.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {
    private final RentalService rentalService;

    @GetMapping("/getAll")
    public List<GetListRentalResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/getById")
    public Rental getById(@RequestParam int id){
        return rentalService.getById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid AddRentalRequest request){
        rentalService.add(request);
        return "Rental Added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeleteRentalRequest request){
        rentalService.delete(request);
        return "Rental Deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdateRentalRequest request){
        rentalService.update(request);
        return "Rental Updated";
    }

}
