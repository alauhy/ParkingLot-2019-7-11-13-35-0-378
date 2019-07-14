package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot implements Parkable, Fetchable {
    private final int capacity;
    private Map<ParkinglotTicket, Car> cars = new HashMap<ParkinglotTicket, Car>();

    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override

    public ParkinglotTicket park(Car car) throws Exception {
        if (isFull() == false) {
            ParkinglotTicket ticket = new ParkinglotTicket();
            cars.put(ticket, car);
            return ticket;
        }
        throw new Exception("Not enough position");
    }

    @Override
    public Car fetchCarbyTicket(ParkinglotTicket ticket) throws Exception {
        if (cars.containsKey(ticket)) {
            Car car = cars.get(ticket);
            cars.remove(ticket);
            return car;
        } else throw new Exception("Unrecongnized parking ticket.");

    }

    @Override
    public Car fetchCarbyTicket() throws Exception {

        throw new Exception("Please provide your parking ticket.");

    }

    private boolean isFull() {
        if (capacity - cars.size() <= 0) {
            return true;
        }
        return false;

    }

    public int restCapacity() {
        return capacity - cars.size();
    }

    public double validRate(){
        return restCapacity()/capacity;
    }
}
