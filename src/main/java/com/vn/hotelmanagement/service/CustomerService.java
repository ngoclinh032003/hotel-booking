package com.vn.hotelmanagement.service;


import java.util.Optional;

import com.vn.hotelmanagement.model.Customer;

public interface CustomerService {

    Optional<Customer> findByUserId(Long userId);

    Optional<Customer> findByUsername(String username);
}
