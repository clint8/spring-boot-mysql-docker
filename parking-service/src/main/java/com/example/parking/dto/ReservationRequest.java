package com.example.parking.dto;

import java.time.LocalDate;

public class ReservationRequest {
    private String customerName;
    private LocalDate parkingDate;
    private Long parkingSpotId;
    private Long timeSlotId;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getParkingDate() {
        return parkingDate;
    }

    public void setParkingDate(LocalDate parkingDate) {
        this.parkingDate = parkingDate;
    }

    public Long getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(Long parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }
}
