package com.vn.hotelmanagement.initialize;

import com.vn.hotelmanagement.model.*;
import com.vn.hotelmanagement.model.enums.RoleType;
import com.vn.hotelmanagement.model.enums.RoomType;
import com.vn.hotelmanagement.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final HotelManagerRepository hotelManagerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final HotelRepository hotelRepository;
    private final AvailabilityRepository availabilityRepository;

    @Override
    @Transactional
    public void run(String... args) {

        try {
            log.warn("Checking if test data persistence is required...");

            if (roleRepository.count() == 0 && userRepository.count() == 0) {
                log.info("Initiating test data persistence");

                Role adminRole = new Role(RoleType.ADMIN);
                Role customerRole = new Role(RoleType.CUSTOMER);
                Role hotelManagerRole = new Role(RoleType.HOTEL_MANAGER);

                roleRepository.save(adminRole);
                roleRepository.save(customerRole);
                roleRepository.save(hotelManagerRole);
                log.info("Role data persisted");

                User user1 = User.builder().username("admin@hotel.com").password(passwordEncoder.encode("1")).name("Admin").lastName("Admin").role(adminRole).build();
                User user2 = User.builder().username("customer1@hotel.com").password(passwordEncoder.encode("1")).name("Nguyen").lastName("Dinh An").role(customerRole).build();
                User user3 = User.builder().username("manager1@hotel.com").password(passwordEncoder.encode("1")).name("Doan").lastName("Anh Quan").role(hotelManagerRole).build();
                User user4 = User.builder().username("manager2@hotel.com").password(passwordEncoder.encode("1")).name("Doan ").lastName("Hong Anh").role(hotelManagerRole).build();

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);

                Admin admin1 = Admin.builder().user(user1).build();
                Customer c1 = Customer.builder().user(user2).build();
                HotelManager hm1 = HotelManager.builder().user(user3).build();
                HotelManager hm2 = HotelManager.builder().user(user4).build();

                adminRepository.save(admin1);
                customerRepository.save(c1);
                hotelManagerRepository.save(hm1);
                hotelManagerRepository.save(hm2);
                log.info("User data persisted");

                Address addressHN1 = Address.builder().addressLine("1 Ngo Gach, Hang Buom, Q. Hoan Kiem").city("Ha Noi")
                        .country("Viet Nam").build();
                Address addressHN2 = Address.builder().addressLine("17 Ngo 45, Tran Thai Tong, Q. Cau Giay").city("Ha Noi")
                        .country("Viet Nam").build();
                Address addressDN1 = Address.builder().addressLine("93 Ha Bong").city("Da Nang")
                        .country("Viet Nam").build();

                Address addressDN2 = Address.builder().addressLine("56 Hoang Dieu, P.Phuoc Ninh, Q. Hai Chau").city("Da Nang")
                        .country("Viet Nam").build();
                Address addressHCM1 = Address.builder().addressLine("6B6 Ha Huy Giap, Khu Nam Long, Q.12").city("Ho Chi Minh")
                        .country("Viet Nam").build();
                Address addressHCM2 = Address.builder().addressLine("5/24 No Trang Long, P.7, Q. Binh Thanh").city("Ho Chi Minh")
                        .country("Viet Nam").build();

                addressRepository.save(addressHN1);
                addressRepository.save(addressHN2);
                addressRepository.save(addressDN1);
                addressRepository.save(addressDN2);
                addressRepository.save(addressHCM1);
                addressRepository.save(addressHCM2);

                Hotel hotelHN1 = Hotel.builder().name("Amira Hotel")
                        .address(addressHN1).hotelManager(hm1).build();
                Hotel hotelHN2 = Hotel.builder().name("Thu Giang Hotel")
                        .address(addressHN2).hotelManager(hm1).build();
                Hotel hotelDN1 = Hotel.builder().name("Dylan Hotel")
                        .address(addressDN1).hotelManager(hm1).build();

                Hotel hotelDN2 = Hotel.builder().name("Thanh Hoang Chau Hotel")
                        .address(addressDN2).hotelManager(hm2).build();
                Hotel hotelHCM1 = Hotel.builder().name("Duc Phuc Hotel")
                        .address(addressHCM1).hotelManager(hm2).build();
                Hotel hotelHCM2 = Hotel.builder().name("Lotus Laverne Hotel")
                        .address(addressHCM2).hotelManager(hm2).build();

                Room singleRoomHN1= Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(370).roomCount(35).hotel(hotelHN1).build();
                Room doubleRoomHN1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(459).roomCount(45).hotel(hotelHN1).build();

                Room singleRoomHN2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(700).roomCount(25).hotel(hotelHN2).build();
                Room doubleRoomHN2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(890).roomCount(30).hotel(hotelHN2).build();

                Room singleRoomDN1 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(691).roomCount(30).hotel(hotelDN1).build();
                Room doubleRoomDN1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(800).roomCount(75).hotel(hotelDN1).build();

                Room singleRoomDN2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(120.0).roomCount(25).hotel(hotelDN2).build();
                Room doubleRoomDN2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(250.0).roomCount(15).hotel(hotelDN2).build();

                Room singleRoomHCM1 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(300).roomCount(50).hotel(hotelHCM1).build();
                Room doubleRoomHCM1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(400).roomCount(50).hotel(hotelHCM1).build();

                Room singleRoomHCM2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(179).roomCount(45).hotel(hotelHCM2).build();
                Room doubleRoomHCM2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(256).roomCount(25).hotel(hotelHCM2).build();

                hotelHN1.getRooms().addAll(Arrays.asList(singleRoomHN1,doubleRoomHN1));
                hotelHN2.getRooms().addAll(Arrays.asList(singleRoomHN2,doubleRoomHN2));
                hotelDN1.getRooms().addAll(Arrays.asList(singleRoomDN1,doubleRoomDN1));
                hotelDN2.getRooms().addAll(Arrays.asList(singleRoomDN2,doubleRoomDN2));
                hotelHCM1.getRooms().addAll(Arrays.asList(singleRoomHCM1,doubleRoomHCM1));
                hotelHCM2.getRooms().addAll(Arrays.asList(singleRoomHCM2,doubleRoomHCM2));

                hotelRepository.save(hotelHN1);
                hotelRepository.save(hotelHN2);
                hotelRepository.save(hotelDN1);
                hotelRepository.save(hotelDN2);
                hotelRepository.save(hotelHCM1);
                hotelRepository.save(hotelHCM2);
                log.info("Hotel data persisted");

                Availability av1DN2 = Availability.builder().hotel(hotelDN2)
                        .date(LocalDate.of(2023,9,1)).room(singleRoomDN2).availableRooms(5).build();
                Availability av2DN2 = Availability.builder().hotel(hotelDN2)
                        .date(LocalDate.of(2023,9,2)).room(doubleRoomDN2).availableRooms(7).build();

                availabilityRepository.save(av1DN2);
                availabilityRepository.save(av2DN2);
                log.info("Availability data persisted");

            } else {
                log.info("Test data persistence is not required");
            }
            log.warn("App ready");
        } catch (DataAccessException e) {
            log.error("Exception occurred during data persistence: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected exception occurred: " + e.getMessage());
        }
    }
}
