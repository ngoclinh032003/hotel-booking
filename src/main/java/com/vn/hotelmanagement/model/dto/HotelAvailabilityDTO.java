package com.vn.hotelmanagement.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class HotelAvailabilityDTO {

    private Long id;

    private String name;

    private AddressDTO addressDTO;
    @Builder.Default
    private List<RoomDTO> roomDTOs = new ArrayList<>();

    private Integer maxAvailableSingleRooms;

    private Integer maxAvailableDoubleRooms;

}
