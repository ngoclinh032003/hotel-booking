package com.vn.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.hotelmanagement.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
