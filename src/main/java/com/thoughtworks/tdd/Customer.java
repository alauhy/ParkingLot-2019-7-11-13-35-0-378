package com.thoughtworks.tdd;

public class Customer {
    private Parkable parkable;
    private Fetchable fetchable;
    private Car car = new Car();
    private ParkinglotTicket parkinglotTicket;

    public void setParkable(Parkable parkable) {
        this.parkable = parkable;
    }

    public void setFetchable(Fetchable fetchable) {
        this.fetchable = fetchable;
    }
    public String parkMyCar()throws Exception{
        try{
           this.parkinglotTicket=parkable.park(car);
           return "";

        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Car getCar() {
        return car;
    }

    public ParkinglotTicket getParkinglotTicket() {
        return parkinglotTicket;
    }

    public String fetchMyCar(ParkinglotTicket ticket) throws Exception{
        try{
            this.car=fetchable.fetchCarbyTicket(ticket);
            return "";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public String fetchMyCar() throws Exception{
        try{
            this.car=fetchable.fetchCarbyTicket();
            return "";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
