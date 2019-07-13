package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Parkinglot_Test {
    @Test
    public void should_park_car_and_fetch_car() {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car);
//        then
        Assertions.assertEquals(car, parkinglot.fetchCarbyTicket(parkinglotTicket));

    }

    @Test
    public void should_return_null_when_parkinglot_is_full_give_car() {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
        Car car2 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
        ParkinglotTicket parkinglotTicket1 = parkinglot.park(car2);
//        then
        Assertions.assertEquals(null,parkinglotTicket1);
    }

}
