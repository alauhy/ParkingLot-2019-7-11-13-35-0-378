package com.thoughtworks.tdd;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Parkinglot_Test {
    @Test
    public void should_park_car_and_fetch_car() throws Exception {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car);
//        then
        Assertions.assertEquals(car, parkinglot.fetchCarbyTicket(parkinglotTicket));

    }

    @Test
    public void should_return_Not_enough_position_when_parkinglot_is_full_give_car() throws Exception {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
        Car car2 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);

//        then
        Assertions.assertThrows(Exception.class, () -> parkinglot.park(car2));
    }

    @Test
    public void should_return__when_ticket_uses_twice_give_ticket() throws Exception {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
        Car car = parkinglot.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertThrows(Exception.class, () -> parkinglot.fetchCarbyTicket(parkinglotTicket));
    }

    @Test
    public void should_return_null_when_fetch_car_give_no_ticket() throws Exception {
//        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertThrows(Exception.class, () -> parkinglot.fetchCarbyTicket());
    }

    @Test
    public void should_return_null_when_fetch_give_wrong_ticket() throws Exception {
        //        given
        Parkinglot parkinglot = new Parkinglot(1);
        Car car1 = new Car();
//        when
        ParkinglotTicket parkinglotTicket = parkinglot.park(car1);
//        then
        Assertions.assertThrows(Exception.class, () -> parkinglot.fetchCarbyTicket(new ParkinglotTicket()));
    }


//    parkingboy's behaviors;


    @Test
    public void should_parking_boy_park_car_and_fetch_car() throws Exception {
//        given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Parkinglot parkinglot1 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkingBoy.setParkinglots(parkinglots);
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car);
//        then
        Assertions.assertEquals(car, parkingBoy.fetchCarbyTicket(parkinglotTicket));

    }


    @Test
    public void should_return_null_when_fetch_car_give_parkingboy_no_ticket() throws Exception {
//        given
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
//        then
        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetchCarbyTicket());
    }

    @Test
    public void should_return_Exception_when_fetch_give_parkingbot_wrong_ticket() throws Exception {
        //        given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Parkinglot parkinglot1 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkingBoy.setParkinglots(parkinglots);
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
//        then
        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetchCarbyTicket(new ParkinglotTicket()));
    }

    @Test
    public void should_return_Exception_when_ticket_uses_twice_give_parkingboy_ticket() throws Exception {
//        given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Parkinglot parkinglot1 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkingBoy.setParkinglots(parkinglots);
//        when
        ParkinglotTicket parkinglotTicket = parkingBoy.park(car1);
        Car car = parkingBoy.fetchCarbyTicket(parkinglotTicket);
//        then
        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetchCarbyTicket(parkinglotTicket));
    }

    @Test
    public void should_return_Unrecongnized_parking_ticket_when_fetch_give_parkingboy_wrong_ticket() throws Exception {
//        given
        Customer customer = new Customer();
        ParkingBoy parkingBoy = new ParkingBoy();
        Parkinglot parkinglot1 = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(1);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Car car1 = new Car();
        parkingBoy.setParkinglots(parkinglots);
//        when
        customer.setParkable(parkingBoy);
        customer.parkMyCar();
        customer.setFetchable(parkingBoy);
        customer.fetchMyCar(customer.getParkinglotTicket());
//        then
        Assertions.assertEquals("Unrecongnized parking ticket.", customer.fetchMyCar(new ParkinglotTicket()));
    }

    @Test
    public void should_return_Unrecongnized_parking_ticket_when_fetch_give_parkingboy_without_ticket() throws Exception {
//        given
        Customer customer = new Customer();
        ParkingBoy parkingBoy = new ParkingBoy();
        Parkinglot parkinglot1 = new Parkinglot(1);
        Parkinglot parkinglot2 = new Parkinglot(1);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Car car1 = new Car();
        parkingBoy.setParkinglots(parkinglots);
//        when
        customer.setParkable(parkingBoy);
        customer.parkMyCar();
        customer.setFetchable(parkingBoy);
        customer.fetchMyCar(customer.getParkinglotTicket());
//        then
        Assertions.assertEquals("Please provide your parking ticket.", customer.fetchMyCar());
    }

    @Test
    public void should_return_car2_in_parkinglot2_when_park_smartly_give_smart_parking_boy_a_car() throws Exception {
//        given
        SmartParkingboy smartParkingboy = new SmartParkingboy();
        Parkinglot parkinglot1 = new Parkinglot(10);
        Parkinglot parkinglot2 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Car car1 = new Car();
        Car car2 = new Car();
        smartParkingboy.setParkinglots(parkinglots);
        ParkinglotTicket parkinglotTicket1 = smartParkingboy.park(car1);
        ParkinglotTicket parkinglotTicket2 = smartParkingboy.park(car2);

//        then
        Assertions.assertEquals(car2, smartParkingboy.getParkinglots().get(1).fetchCarbyTicket(parkinglotTicket2));
    }

    @Test
    public void should_return_car2_in_parkinglot2_when_park_smartly_give_super_smart_parking_boy_a_car() throws Exception {
//        given
        SuperSmartParkingboy superSmartParkingboy = new SuperSmartParkingboy();
        Parkinglot parkinglot1 = new Parkinglot(4);
        Parkinglot parkinglot2 = new Parkinglot(2);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Car car1 = new Car();
        Car car2 = new Car();
        superSmartParkingboy.setParkinglots(parkinglots);
        ParkinglotTicket parkinglotTicket1 = superSmartParkingboy.park(car1);
        ParkinglotTicket parkinglotTicket2 = superSmartParkingboy.park(car2);

//        then
        Assertions.assertEquals(car2, superSmartParkingboy.getParkinglots().get(1).fetchCarbyTicket(parkinglotTicket2));
    }

    @Test
    public void should_park_car_and_fetch_car_when_manage_send_a_parkingboy_give_a_car() throws Exception {

//        given
        Parkinglot parkinglot1 = new Parkinglot(10);
        Parkinglot parkinglot2 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Manager manager = new Manager(parkinglots);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        manager.addParkingboy(parkingBoy);
        manager.addParkingboy(parkingBoy2);
        manager.provideParkinglottoParkingboy(parkingBoy);
        manager.provideParkinglottoParkingboy(parkingBoy2);
        Car car1 = new Car();
        Car car2 = new Car();
//        when
        manager.setParkable(parkingBoy);
        manager.setFetchable(parkingBoy);
        ParkinglotTicket parkinglotTicket=manager.parkCar(car1);
        Car car=manager.fetchCar(parkinglotTicket);
//        then
        Assertions.assertEquals(car1, car);
    }
    @Test
    public void should_park_car_but_no_car_fetch_when_manage_send_a_parkingboy_to_park_anoother_to_fetch_give_a_car() throws Exception {

//        given
        Parkinglot parkinglot1 = new Parkinglot(10);
        Parkinglot parkinglot2 = new Parkinglot(10);
        List<Parkinglot> parkinglots = new ArrayList<>();
        parkinglots.add(parkinglot1);
        parkinglots.add(parkinglot2);
        Manager manager = new Manager(parkinglots);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        manager.addParkingboy(parkingBoy);
        manager.addParkingboy(parkingBoy2);
        manager.provideParkinglottoParkingboy(parkingBoy);
        manager.provideParkinglottoParkingboy(parkingBoy2);
        Car car1 = new Car();
//        when
        manager.setParkable(parkingBoy);
        manager.setFetchable(parkingBoy2);
        ParkinglotTicket parkinglotTicket=manager.parkCar(car1);
//        then
        Assertions.assertThrows(Exception.class, ()->manager.fetchCar(parkinglotTicket));
    }

}
