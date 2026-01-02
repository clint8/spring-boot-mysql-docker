package com.example.parking.controller;

import com.example.parking.domain.ParkingSpot;
import com.example.parking.domain.Reservation;
import com.example.parking.domain.TimeSlot;
import com.example.parking.dto.ReservationRequest;
import com.example.parking.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/availability")
    public List<Map<String, Object>> getAvailability(@RequestParam LocalDate date) {
        return parkingService.getAvailableSlots(date);
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return parkingService.getAllReservations();
    }

    @PostMapping("/reservations")
    public Reservation createReservation(@RequestBody ReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setCustomerName(request.getCustomerName());
        reservation.setParkingDate(request.getParkingDate());

        ParkingSpot spot = new ParkingSpot();
        spot.setId(request.getParkingSpotId());
        reservation.setParkingSpot(spot);

        TimeSlot slot = new TimeSlot();
        slot.setId(request.getTimeSlotId());
        reservation.setTimeSlot(slot);

        return parkingService.createReservation(reservation);
    }
}
