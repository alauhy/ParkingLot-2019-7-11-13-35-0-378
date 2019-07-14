package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Manager extends ParkingBoy {
    private Fetchable fetchable;
    private Parkable parkable;
    private List<ParkingBoy> parkingboyManageList = new ArrayList<>();
    private List<Parkinglot> parkinglots = new ArrayList<>();
    private Map<Parkinglot,ParkingBoy> parkinglotManagement = new HashMap<>();


    public void addParkingboy(ParkingBoy parkingBoy){

        parkingboyManageList.add(parkingBoy);

    }

    public Manager(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public void provideParkinglottoParkingboy(ParkingBoy parkingBoy)throws Exception{
        if(parkingboyManageList.contains(parkingBoy)) {
            List<Parkinglot> unrangedParkinglots = parkinglots.stream().filter(e -> !parkinglotManagement.containsKey(e)).collect(Collectors.toList());
            if (unrangedParkinglots.size() > 0) {
                parkinglotManagement.put(unrangedParkinglots.get(0), parkingBoy);
                parkingBoy.setParkinglots(unrangedParkinglots.get(0));
            }
            else throw new Exception("not enough parkinglot to provide");
        }
        else throw new Exception("the parking boy is not your man1");


    }
    public void setFetchable(Fetchable fetchable) throws Exception{
        if(parkingboyManageList.contains(fetchable)) {
            this.fetchable = fetchable;
        }
        else throw new Exception("the parking boy is not your man2");
    }

    public void setParkable(Parkable parkable) throws Exception{
        if(parkingboyManageList.contains(parkable)){
            this.parkable = parkable;
        }
        else throw new Exception("the parking boy is not your man3");
    }

    public ParkinglotTicket parkCar(Car car) throws Exception{
       try{
           return parkable.park(car);
       }catch (Exception e){
           throw e;
       }
    }

    public Car fetchCar(ParkinglotTicket parkinglotTicket) throws Exception{
        try{
           return fetchable.fetchCarbyTicket(parkinglotTicket);
        }catch (Exception e){
            throw e;
        }
    }
    public Car fetchCar() throws Exception{
        try{
            return fetchable.fetchCarbyTicket();
        }catch (Exception e){
            throw e;
        }
    }


}
