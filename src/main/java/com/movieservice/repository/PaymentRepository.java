package com.movieservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.movieservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
