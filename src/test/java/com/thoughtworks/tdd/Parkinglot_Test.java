package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot_Test {
    @Test
    public void should_park_car_and_fetch_car() throws Exception{
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car);
//        then
        Assertions.assertEquals(car, parkinglot.fetchCarbyTicket(parkinglotTicket));

    }

    @Test
    public void should_return_exception_when_parkinglot_is_full_give_car() throws Exception{
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
        Car car2 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        ParkinglotTicket parkinglotTicket1 = parkinglot.park(car2);
//        then
        Assertions.assertThrows(Exception.class, ()->parkinglot.park(car2));
    }

    @Test
    public void should_return_null_when_ticket_uses_twice_give_ticket() throws Exception{
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
        Car car = parkinglot.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertThrows(Exception.class, ()->parkinglot.fetchCarbyTicket(parkinglotTicket));
    }

    @Test
    public void should_return_null_when_fetch_car_give_no_ticket() throws Exception{
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertThrows(Exception.class, ()->parkinglot.fetchCarbyTicket());
    }

    @Test
    public void should_return_null_when_fetch_give_wrong_ticket() throws Exception{
        //        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertThrows(Exception.class, ()->parkinglot.fetchCarbyTicket(new ParkinglotTicket()));
    }



//    parkingboy's behaviors;


    @Test
    public void should_parking_boy_park_car_and_fetch_car() throws Exception{
//        given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car);
//        then
        Assertions.assertEquals(car, parkingBoy.fetchCarbyTicket(parkinglotTicket) );

    }

//    @Test
//    public void should_parking_boy_park_multiple_cars_and_fetch_cars() throws Exception{
////        given
//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car());
//        cars.add(new Car());
//        cars.add(new Car());
//        cars.add(new Car());
//        ParkingBoy parkingBoy = new ParkingBoy();
////        when
//        List<ParkinglotTicket> parkinglotTickets = parkingBoy.park(cars);
////        then
//        Assertions.assertEquals(cars, parkingBoy.fetchCarbyTicket(parkinglotTickets));
//
//    }

    @Test
    public void should_return_null_when_fetch_car_give_parkingboy_no_ticket() throws Exception{
//        given
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
//        then
        Assertions.assertThrows(Exception.class,()-> parkingBoy.fetchCarbyTicket());
    }

    @Test
    public void should_return_Exception_when_fetch_give_parkingbot_wrong_ticket() throws Exception{
        //        given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
//        then
        Assertions.assertThrows(Exception.class, ()->parkingBoy.fetchCarbyTicket(new ParkinglotTicket()));
    }
    @Test
    public void should_return_Exception_when_ticket_uses_twice_give_parkingboy_ticket() throws Exception{
//        given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
        Car car = parkingBoy.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertThrows(Exception.class, ()->parkingBoy.fetchCarbyTicket(parkinglotTicket));
    }
    @Test
    public void should_return_Unrecongnized_parking_ticket_when_fetch_give_parkingboy_wrong_ticket() throws Exception{
//        given
        Customer customer = new Customer();
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
//        when
        customer.setParkable(parkingBoy);
        customer.parkMyCar(car1);
        customer.setFetchable(parkingBoy);
        customer.fetchMyCar(customer.getParkinglotTicket());
//        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
//        Car car = parkingBoy.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertEquals("Unrecongnized parking ticket.", customer.fetchMyCar(new ParkinglotTicket()));
    }
}
