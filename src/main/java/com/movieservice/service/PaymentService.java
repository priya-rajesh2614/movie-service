package com.movieservice.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.movieservice.dto.PaymentRequest;
import com.movieservice.entity.Payment;
import com.movieservice.entity.Seat;
import com.movieservice.repository.PaymentRepository;
import com.movieservice.repository.SeatRepository;

@Service
public class PaymentService {

    
    private PaymentRepository paymentRepository;

    
    private SeatRepository seatRepository;

    public PaymentService(PaymentRepository paymentRepository, SeatRepository seatRepository) {
		super();
		this.paymentRepository = paymentRepository;
		this.seatRepository = seatRepository;
	}

    public ResponseEntity<Map<String, String>> processPayment(PaymentRequest paymentRequest) {
        Map<String, String> response = new HashMap<>();

        List<Seat> seats = seatRepository.findByIdIn(paymentRequest.getSelectedSeats());

        if (seats.size() != paymentRequest.getSelectedSeats().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Some seats do not exist.");
        }

        boolean anySeatBooked = seats.stream().anyMatch(Seat::getIsBooked);
        if (anySeatBooked) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more selected seats are already booked.");
        }

        Payment payment = new Payment(
            "TXN" + System.currentTimeMillis(),
            paymentRequest.getUserEmail(),
            paymentRequest.getPaymentMethod(),
            paymentRequest.getAmount(),
            "Success",
            paymentRequest.getSelectedSeats()
        );
        paymentRepository.save(payment);

        seats.forEach(seat -> seat.setIsBooked(true));
        seatRepository.saveAll(seats);

        response.put("status", "success");
        response.put("message", "Payment successful! Seats booked.");
        response.put("transactionId", payment.getTransactionId());

        return ResponseEntity.ok(response);
    }

}
