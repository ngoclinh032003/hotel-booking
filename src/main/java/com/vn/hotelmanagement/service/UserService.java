package com.vn.hotelmanagement.service;


import java.util.List;

import com.vn.hotelmanagement.model.User;
import com.vn.hotelmanagement.model.dto.ResetPasswordDTO;
import com.vn.hotelmanagement.model.dto.UserDTO;
import com.vn.hotelmanagement.model.dto.UserRegistrationDTO;

public interface UserService {

    User saveUser(UserRegistrationDTO registrationDTO);

    // For registration
    User findUserByUsername(String username);

    UserDTO findUserDTOByUsername(String username);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    void updateUser(UserDTO userDTO);

    void updateLoggedInUser(UserDTO userDTO);

    void deleteUserById(Long id);

    User resetPassword(ResetPasswordDTO resetPasswordDTO);

}
