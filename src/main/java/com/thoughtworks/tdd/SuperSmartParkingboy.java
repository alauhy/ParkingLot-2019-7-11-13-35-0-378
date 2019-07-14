package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingboy extends ParkingBoy {
    @Override
    public List<Parkinglot> getParkinglots() {
        return super.getParkinglots();
    }

    @Override
    public ParkinglotTicket park(Car car) throws Exception {
        try {
            Parkinglot parkinglot = findEmptiestParkinglot();
            return parkinglot.park(car);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setParkinglots(List<Parkinglot> parkinglots) {
        super.setParkinglots(parkinglots);
    }

    @Override
    public Car fetchCarbyTicket(ParkinglotTicket ticket) throws Exception {
        return super.fetchCarbyTicket(ticket);
    }

    @Override
    public Car fetchCarbyTicket() throws Exception {
        return super.fetchCarbyTicket();
    }

    private Parkinglot findEmptiestParkinglot() {
        return super.getParkinglots().stream().max((a, b) -> a.validRate() >= b.validRate() ? 1 : -1).get();

    }
}
