package com.example.parking.service;

import com.example.parking.domain.Reservation;
import com.example.parking.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ParkingService {

    private final ReservationRepository reservationRepository;

    public ParkingService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Map<String, Object>> getAvailableSlots(LocalDate date) {
        return reservationRepository.findAvailableSlots(date);
    }

    public Reservation createReservation(Reservation reservation) {
        // Basic validation: check if slot is actually available?
        // For simplicity assuming UI/Client sends valid available IDs or we catch UK
        // constraint violation if we had one.
        // But for better UX, we could check here.
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
