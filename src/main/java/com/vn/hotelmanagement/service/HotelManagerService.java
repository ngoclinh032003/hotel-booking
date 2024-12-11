package com.vn.hotelmanagement.service;

import com.vn.hotelmanagement.model.HotelManager;
import com.vn.hotelmanagement.model.User;

public interface HotelManagerService {

    HotelManager findByUser(User user);

}
