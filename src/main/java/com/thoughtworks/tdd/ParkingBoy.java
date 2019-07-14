package com.thoughtworks.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingBoy implements Parkable, Fetchable {
    private List<Parkinglot> parkinglots = new ArrayList<>();

    public List<Parkinglot> getParkinglots() {
        return parkinglots;
    }

    @Override
    public ParkinglotTicket park(Car car) throws Exception {

        for (int i = 0; i < parkinglots.size(); i++) {
            try {

                return parkinglots.get(i).park(car);
            } catch (Exception e) {
                if (i < parkinglots.size() - 1) {
                    continue;
                }

                throw e;

            }
        }
        return null;

    }

    public void setParkinglots(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public void setParkinglots(Parkinglot parkinglots) {
        this.parkinglots.add(parkinglots);
    }

    //    public List<ParkinglotTicket> park(List<Car> cars) throws Exception {
//
//        List<ParkinglotTicket> tickets=cars.stream().map(e -> parkinglot.park(e)).collect(Collectors.toList());
//
//
//    }
    @Override
    public Car fetchCarbyTicket(ParkinglotTicket ticket) throws Exception {

        for (int i = 0; i < parkinglots.size(); i++) {
            try {
                return parkinglots.get(i).fetchCarbyTicket(ticket);
            } catch (Exception e) {
                if (i < parkinglots.size() - 1) {
                    continue;
                } else throw e;
            }
        }
        return null;

    }

    //    public List<Car> fetchCarbyTicket(List<ParkinglotTicket> tickets) {
//
//        return tickets.stream().map(e -> parkinglot.fetchCarbyTicket(e)).collect(Collectors.toList());
//    }
    @Override
    public Car fetchCarbyTicket() throws Exception {
        try {
            return parkinglots.get(0).fetchCarbyTicket();
        } catch (Exception e) {
            throw e;
        }

    }

}
