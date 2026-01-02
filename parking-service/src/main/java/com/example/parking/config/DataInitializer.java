package com.example.parking.config;

import com.example.parking.domain.ParkingSpot;
import com.example.parking.domain.TimeSlot;
import com.example.parking.repository.ParkingSpotRepository;
import com.example.parking.repository.TimeSlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ParkingSpotRepository spotRepository, TimeSlotRepository timeRepository) {
        return args -> {
            if (spotRepository.count() == 0) {
                spotRepository.save(createSpot("A1", true));
                spotRepository.save(createSpot("A2", true));
                spotRepository.save(createSpot("B1", false));
                spotRepository.save(createSpot("B2", false));
                spotRepository.save(createSpot("B3", false));
            }

            if (timeRepository.count() == 0) {
                IntStream.range(8, 18).forEach(hour -> {
                    TimeSlot slot = new TimeSlot();
                    slot.setStartTime(hour);
                    slot.setLabel(String.format("%02d:00 - %02d:00", hour, hour + 1));
                    timeRepository.save(slot);
                });
            }
        };
    }

    private ParkingSpot createSpot(String number, boolean premium) {
        ParkingSpot spot = new ParkingSpot();
        spot.setSpotNumber(number);
        spot.setPremium(premium);
        return spot;
    }
}
