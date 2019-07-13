package com.thoughtworks.tdd;

public interface Fetchable {
    Car fetchCarbyTicket(ParkinglotTicket parkinglotTicket) throws Exception;
    Car fetchCarbyTicket() throws Exception;

}
