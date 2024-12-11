package com.vn.hotelmanagement.service;

import com.vn.hotelmanagement.model.Booking;
import com.vn.hotelmanagement.model.Payment;
import com.vn.hotelmanagement.model.dto.BookingInitiationDTO;

public interface PaymentService {

    Payment savePayment(BookingInitiationDTO bookingInitiationDTO, Booking booking);
}
