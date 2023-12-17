package com.sava.rentingservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sava.rentingservice.dto.RentingInfoDTO;
import com.sava.rentingservice.entity.Renting;
import com.sava.rentingservice.service.RentingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/renting")
@RequiredArgsConstructor
public class RentingController {
    private final RentingService rentingService;

    @GetMapping
    public List<RentingInfoDTO> getRentingInfo() {
        return rentingService.getRentingInfo();
    }

    @PostMapping("/rent")
    public String rentBook(@RequestBody Renting renting) {
        return rentingService.rentBook(renting);
    }
}
