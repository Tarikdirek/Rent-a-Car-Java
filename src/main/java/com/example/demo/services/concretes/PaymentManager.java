package com.example.demo.services.concretes;

import com.example.demo.entities.Card;
import com.example.demo.entities.Payment;
import com.example.demo.entities.User;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.services.abstracts.CardService;
import com.example.demo.services.abstracts.PaymentService;
import com.example.demo.services.abstracts.UserService;
import com.example.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.example.demo.services.dtos.payment.requests.DeletePaymentRequest;
import com.example.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.example.demo.services.dtos.payment.responses.GetListPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final CardService cardService;

    public void add(AddPaymentRequest request) {

        if (cardService.getById(request.getCardId()).getId()<0)
        {
            throw new IllegalArgumentException("There is no card like that");
        }


        Payment paymentToAdd = new Payment();
        paymentToAdd.setPaymentFee(request.getPaymentFee());
        User user = userService.getById(request.getUserId());
        paymentToAdd.setUser(user);
        Card card = cardService.getById(request.getCardId());
        paymentToAdd.setCard(card);
        paymentRepository.save(paymentToAdd);
    }

    public void delete(DeletePaymentRequest request) {
        Payment paymentToDelete = paymentRepository.findById(request.getId()).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    public void update(UpdatePaymentRequest request) {
        Payment paymentToUpdate = paymentRepository
                .findById(request.getId()).orElseThrow(()-> new RuntimeException("The payment does not exist"));
        paymentToUpdate.setPaymentFee(request.getPaymentFee());
        User user = userService.getById(request.getUserId());
        paymentToUpdate.setUser(user);
        Card card = cardService.getById(request.getCardId());
        paymentToUpdate.setCard(card);
        paymentRepository.saveAndFlush(paymentToUpdate);

    }

    public List<GetListPaymentResponse> getAll() {
        return paymentRepository.getAll();
    }

    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow();
    }
}
