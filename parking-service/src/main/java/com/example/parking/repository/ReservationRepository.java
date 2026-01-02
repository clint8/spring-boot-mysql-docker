package com.example.parking.repository;

import com.example.parking.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Simplest way to return projection is Map or Interface, Map is easier for demo
    @Query(value = "SELECT s.id as spotId, s.spot_number as spotNumber, t.id as timeId, t.label as timeLabel " +
            "FROM parking_spot s CROSS JOIN time_slot t " +
            "LEFT JOIN reservation r ON r.parking_spot_id = s.id AND r.time_slot_id = t.id AND r.parking_date = :date "
            +
            "WHERE r.id IS NULL " +
            "ORDER BY t.start_time, s.spot_number", nativeQuery = true)
    List<Map<String, Object>> findAvailableSlots(@Param("date") LocalDate date);
}
