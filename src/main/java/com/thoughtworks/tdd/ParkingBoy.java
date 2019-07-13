package com.thoughtworks.tdd;

import java.util.*;

public class ParkingBoy {
    private Parkinglot parkinglot = new Parkinglot(10);

    public ParkinglotTicket park(Car car) {

        return parkinglot.park(car);

    }

    public Car fetchCarbyTicket(ParkinglotTicket ticket){

        return parkinglot.fetchCarbyTicket(ticket);
    }
}
