package hu.uni.eszterhazy.multiparadigm;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.uni.eszterhazy.multiparadigm.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Parking Garage Modeling
 *
 * - Cars, Bikes, Trucks, Space shuttles can park in the Garage.
 * - 1 parking slot can store a car, bike, truck or space shuttle but no other types.
 * - In other words, Car parking slots can store only cars.
 * - Garage has limited number of slots for each type of vehicles.
 *
 *
 */
@Log
public class App
{
    public static void main( String[] args ) throws IOException {
        Car car1 = new Car("abc-123", "black", "BMW", "X5");

        Collection<Car> cars = Arrays.asList(
            new Car("abc-123","black", "BMV", "X5"),
            new Car("asd-123", "green", "Opel", "Corse"),
            new Car("qwe-432", "yellow", "Porshce", "911")
        );

        Collection<ParkingSlotLogEntry> logs =  Arrays.asList(
            new ParkingSlotLogEntry(car1, "8:00", "C4", "ARRIVED"),
            new ParkingSlotLogEntry(car1, "12:00", "C4", "LEFT")
        );

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(System.out, logs);

        log.info(String.format("%s parked at %d",car1, 1));
        log.info(String.format("%s left  %d",car1, 1));
    }

    @Data
    @AllArgsConstructor
    public static class ParkingSlotLogEntry{

        private Car car;
        private String timestamp;
        private String parkingSlot;
        private String direction;
    }
}
