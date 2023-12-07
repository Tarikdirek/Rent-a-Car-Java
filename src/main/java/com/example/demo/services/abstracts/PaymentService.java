package com.example.demo.services.abstracts;

import com.example.demo.entities.Payment;
import com.example.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.example.demo.services.dtos.payment.requests.DeletePaymentRequest;
import com.example.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.example.demo.services.dtos.payment.responses.GetListPaymentResponse;

import java.util.List;

public interface PaymentService {
    void add(AddPaymentRequest request);
    void delete(DeletePaymentRequest request);
    void update(UpdatePaymentRequest request);
    List<GetListPaymentResponse> getAll();
    Payment getById(int id);
}
