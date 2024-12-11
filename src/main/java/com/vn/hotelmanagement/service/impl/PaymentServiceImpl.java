package com.vn.hotelmanagement.service.impl;

import com.vn.hotelmanagement.model.Booking;
import com.vn.hotelmanagement.model.Payment;
import com.vn.hotelmanagement.model.dto.BookingInitiationDTO;
import com.vn.hotelmanagement.model.enums.Currency;
import com.vn.hotelmanagement.model.enums.PaymentMethod;
import com.vn.hotelmanagement.model.enums.PaymentStatus;
import com.vn.hotelmanagement.repository.PaymentRepository;
import com.vn.hotelmanagement.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(BookingInitiationDTO bookingInitiationDTO, Booking booking) {
        Payment payment = Payment.builder()
                .booking(booking)
                .totalPrice(bookingInitiationDTO.getTotalPrice())
                .paymentStatus(PaymentStatus.COMPLETED) // Assuming the payment is completed
                .paymentMethod(PaymentMethod.CREDIT_CARD) // Default to CREDIT_CARD
                .currency(Currency.USD) // Default to USD
                .build();

        Payment savedPayment = paymentRepository.save(payment);
        log.info("Payment saved with transaction ID: {}", savedPayment.getTransactionId());

        return savedPayment;
    }
}
