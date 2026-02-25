package com.demo.service;

import com.demo.model.Reservation;
import java.util.Optional;

public interface ReservationService {

    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long id);

    void update(Reservation reservation);
}