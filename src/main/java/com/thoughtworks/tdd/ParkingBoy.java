package com.thoughtworks.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingBoy implements Parkable,Fetchable{
    private Parkinglot parkinglot = new Parkinglot(10);

    @Override
    public ParkinglotTicket park(Car car) throws Exception {
       try {
           return parkinglot.park(car);
       }catch (Exception e){
           throw e;
       }



    }

//    public List<ParkinglotTicket> park(List<Car> cars) throws Exception {
//
//        List<ParkinglotTicket> tickets=cars.stream().map(e -> parkinglot.park(e)).collect(Collectors.toList());
//
//
//    }
    @Override
    public Car fetchCarbyTicket(ParkinglotTicket ticket) throws Exception {
        try {
            return parkinglot.fetchCarbyTicket(ticket);
        } catch (Exception e) {
            throw e;
        }

    }

//    public List<Car> fetchCarbyTicket(List<ParkinglotTicket> tickets) {
//
//        return tickets.stream().map(e -> parkinglot.fetchCarbyTicket(e)).collect(Collectors.toList());
//    }
    @Override
    public Car fetchCarbyTicket() throws Exception{
       try{
           return parkinglot.fetchCarbyTicket();
       }catch (Exception e){
           throw e;
       }

    }

}
