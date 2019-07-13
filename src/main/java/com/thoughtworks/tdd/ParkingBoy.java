package com.thoughtworks.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingBoy {
    private Parkinglot parkinglot = new Parkinglot(10);

    public ParkinglotTicket park(Car car) {

        return parkinglot.park(car);

    }

    public List<ParkinglotTicket> park(List<Car> cars) {
        return cars.stream().map(e -> parkinglot.park(e)).collect(Collectors.toList());

    }

    public Car fetchCarbyTicket(ParkinglotTicket ticket) {

        return parkinglot.fetchCarbyTicket(ticket);
    }
    public List<Car> fetchCarbyTicket(List<ParkinglotTicket> tickets) {

        return tickets.stream().map(e -> parkinglot.fetchCarbyTicket(e)).collect(Collectors.toList());
    }
}
