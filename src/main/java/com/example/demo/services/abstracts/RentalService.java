package com.example.demo.services.abstracts;

import com.example.demo.entities.Rental;
import com.example.demo.services.dtos.rental.requests.AddRentalRequest;
import com.example.demo.services.dtos.rental.requests.DeleteRentalRequest;
import com.example.demo.services.dtos.rental.requests.UpdateRentalRequest;
import com.example.demo.services.dtos.rental.responses.GetListRentalResponse;

import java.util.List;

public interface RentalService {
    void add(AddRentalRequest request);
    void delete(DeleteRentalRequest request);
    void update (UpdateRentalRequest request);

    List<GetListRentalResponse> getAll();

    Rental getById(int id);
}
