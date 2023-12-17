package com.sava.rentingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sava.rentingservice.comunication.CommunicationService;
import com.sava.rentingservice.dto.RentingInfoDTO;
import com.sava.rentingservice.entity.Renting;
import com.sava.rentingservice.repository.RentingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentingService {
    private final RentingRepository rentingRepository;
    private final CommunicationService communicationService;

    public List<RentingInfoDTO> getRentingInfo() {
        return rentingRepository//
                .findAll()//
                .stream()//
                .map(renting -> {
                    RentingInfoDTO dto = new RentingInfoDTO();

                    String rentedBookName = communicationService.getBookById(renting.getBookId()).getName();
                    dto.setBookName(rentedBookName);

                    String userName = communicationService.getUserId(renting.getUserId()).getName();
                    dto.setUserName(userName);

                    dto.setMessage(String.format("User with name %s rented book %s", userName,
                            rentedBookName));

                    return dto;
                })//
                .toList();

    }

    public String rentBook(Renting renting) {
        rentingRepository.create(renting);
        communicationService.decreaseBook(renting.getBookId());
        return String.format("User with id %s rented book.", renting.getUserId());
    }
}
