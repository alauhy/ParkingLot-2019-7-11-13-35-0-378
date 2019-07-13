package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        Assertions.assertEquals(null, parkinglotTicket1);
    }

    @Test
    public void should_return_null_when_ticket_uses_twice_give_ticket() {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
        Car car = parkinglot.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertEquals(null, parkinglot.fetchCarbyTicket(parkinglotTicket));
    }

    @Test
    public void should_return_null_when_fetch_car_give_no_ticket() {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertEquals(null, parkinglot.fetchCarbyTicket());
    }

    @Test
    public void should_return_null_when_fetch_give_wrong_ticket() {
        //        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertEquals(null, parkinglot.fetchCarbyTicket(new ParkinglotTicket()));
    }

    @Test
    public void should_parking_boy_park_car_and_fetch_car() {
//        given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car);
//        then
        Assertions.assertEquals(car, parkingBoy.fetchCarbyTicket(parkinglotTicket));

    }
    @Test
    public void should_parking_boy_park_multiple_cars_and_fetch_cars() {
//        given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        ParkingBoy parkingBoy = new ParkingBoy();
//        when
        List<ParkinglotTicket> parkinglotTickets = parkingBoy.park(cars);
//        then
        Assertions.assertEquals(cars, parkingBoy.fetchCarbyTicket(parkinglotTickets));

    }
}
