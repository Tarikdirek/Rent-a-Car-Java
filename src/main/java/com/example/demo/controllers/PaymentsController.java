package com.example.demo.controllers;

import com.example.demo.entities.Payment;
import com.example.demo.services.abstracts.PaymentService;
import com.example.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.example.demo.services.dtos.payment.requests.DeletePaymentRequest;
import com.example.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.example.demo.services.dtos.payment.responses.GetListPaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    @GetMapping("/getAll")
    public List<GetListPaymentResponse> getAll(){
       return paymentService.getAll();
    }

    @GetMapping("/getById")
    public Payment getById(@RequestParam int id){
        return paymentService.getById(id);
    }
    @PostMapping("/add")
    public String add(@RequestBody @Valid AddPaymentRequest request){
        paymentService.add(request);
        return "Payment Added";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody @Valid DeletePaymentRequest request){
        paymentService.delete(request);
        return "Payment Deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody @Valid UpdatePaymentRequest request){
        paymentService.update(request);
        return "Payment Updated";
    }



}
