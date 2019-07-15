package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingboy extends ParkingBoy {
    @Override
    public ParkinglotTicket park(Car car) throws Exception {
        try {
            return findEmptiestParkinglot().park(car);
        } catch (Exception e) {
            throw e;
        }
    }


    private Parkinglot findEmptiestParkinglot() {
        return super.getParkinglots().stream().max((a, b) -> a.restCapacity() >= b.restCapacity() ? 1 : -1).get();

    }

}
