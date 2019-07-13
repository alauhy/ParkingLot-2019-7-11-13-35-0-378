package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private final int capacity;
    private Map<ParkinglotTicket,Car> cars = new HashMap<ParkinglotTicket,Car>();
    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }
    public ParkinglotTicket park(Car car){
        ParkinglotTicket ticket = new ParkinglotTicket();
        cars.put(ticket,car);
        return ticket;
    }
    public Car fetchCarbyTicket(ParkinglotTicket ticket){
        return cars.get(ticket);
    }

}
