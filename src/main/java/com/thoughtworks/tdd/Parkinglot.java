package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private final int capacity;
    private Map<ParkinglotTicket, Car> cars = new HashMap<ParkinglotTicket, Car>();

    public Parkinglot(int capacity) {
        this.capacity = capacity;
    }

    public ParkinglotTicket park(Car car) {
        if(isFull()==false){
            ParkinglotTicket ticket = new ParkinglotTicket();
            cars.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car fetchCarbyTicket(ParkinglotTicket ticket) {
        if(cars.containsKey(ticket)){
            Car car=cars.get(ticket);
            cars.remove(ticket);
            return car;
        }
        return null;

    }
    public Car fetchCarbyTicket() {

        return null;

    }

    private boolean isFull() {
        if (capacity - cars.size() <= 0) {
            return true;
        }
        return false;

    }


}
