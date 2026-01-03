package com.example.parking.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private String customerName;
    private LocalDate parkingDate;
    private Long parkingSpotId;
    private Long timeSlotId;
}
