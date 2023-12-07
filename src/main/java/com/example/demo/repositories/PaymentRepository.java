package com.example.demo.repositories;

import com.example.demo.entities.Payment;
import com.example.demo.services.dtos.payment.responses.GetListPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query("select  new com.example.demo.services.dtos.payment.responses.GetListPaymentResponse(p.id,p.paymentFee,new com.example.demo.services.dtos.user.responses.GetListUserResponse(u.id,u.email,u.password) ," +
            "new com.example.demo.services.dtos.card.responses.GetListCardResponseWithId(ca.id,ca.validDate,ca.cvvNum,ca.cardNumber,ca.ownerFullName)) " +
            "from  Payment p inner join p.card ca inner join p.user u")
    List<GetListPaymentResponse> getAll();
}
