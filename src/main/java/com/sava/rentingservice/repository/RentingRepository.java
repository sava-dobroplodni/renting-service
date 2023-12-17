package com.sava.rentingservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sava.rentingservice.entity.Renting;

@Service
public class RentingRepository {
    private List<Renting> rentings = new ArrayList<>();

    public RentingRepository() {
        rentings.add(new Renting("lXYbauHEyp2a8fl2zBKZ9", "pXMfCmCNutD2aEj-Mh0IV"));
        rentings.add(new Renting("Y13_1ZLlHOomj7aBRMN_k", "vriqEY-T23ztxhPubjYmW"));
    }

    public List<Renting> findAll() {
        return rentings;
    }

    public Boolean create(Renting renting) {
        rentings.add(renting);
        return true;
    }

}
