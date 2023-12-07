package com.example.demo.services.concretes;

import com.example.demo.entities.Car;
import com.example.demo.entities.Rental;
import com.example.demo.entities.User;
import com.example.demo.repositories.RentalRepository;
import com.example.demo.services.abstracts.*;
import com.example.demo.services.dtos.rental.requests.AddRentalRequest;
import com.example.demo.services.dtos.rental.requests.DeleteRentalRequest;
import com.example.demo.services.dtos.rental.requests.UpdateRentalRequest;
import com.example.demo.services.dtos.rental.responses.GetListRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {

    private  final RentalRepository rentalRepository;
    private final CarService carService;
    private final UserService userService;




    public void add(AddRentalRequest request)
    {
        if (!carService.getById(request.getCarId()).getStatus().equals("Available")) {
            throw new RuntimeException("This car can not available for rent ");
        }

        Rental rentalToAdd = new Rental();
        rentalToAdd.setRentDate(request.getRentDate());
        rentalToAdd.setReturnDate(request.getReturnDate());
        Car car =carService.getById(request.getCarId());
        rentalToAdd.setCar(car);
        User user = userService.getById(request.getUserId());
        rentalToAdd.setUser(user);
        rentalRepository.save(rentalToAdd);
    }

    public void delete(DeleteRentalRequest request) {
        Rental rentalToDelete = rentalRepository.findById(request.getId()).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    public void update(UpdateRentalRequest request) {

        if (!rentalRepository.existsById(request.getId())) {
            throw new RuntimeException("There is no rental exist like that");
        }

        Rental rentalToUpdate = rentalRepository.findById(request.getId()).orElseThrow();
        rentalToUpdate.setRentDate(request.getRentDate());
        rentalToUpdate.setReturnDate(request.getReturnDate());
        Car car =carService.getById(request.getCarId());
        rentalToUpdate.setCar(car);
        User user = userService.getById(request.getUserId());
        rentalToUpdate.setUser(user);
        rentalRepository.saveAndFlush(rentalToUpdate);
    }

    public List<GetListRentalResponse> getAll() {
        return rentalRepository.findAll().stream().map(rental ->
        {
            GetListRentalResponse response = new GetListRentalResponse();
            response.setId(rental.getId());
            response.setCarId(rental.getCar().getId());
            response.setRentDate(rental.getRentDate());
            response.setReturnDate(rental.getReturnDate());
            response.setUserId(rental.getUser().getId());
            return  response;
        }).toList();
    }

    public Rental getById(int id) {
        return rentalRepository.findById(id).orElseThrow();
    }
}
