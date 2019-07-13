package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Parkinglot_Test {
    @Test
    public void should_park_car_and_fetch_car() {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car = new Car();

        ParkinglotTicket parkinglotTicket=parkinglot.park(car);
//        then
        Assertions.assertEquals(car,parkinglot.fetchCarbyTicket(parkinglotTicket));

    }
}
