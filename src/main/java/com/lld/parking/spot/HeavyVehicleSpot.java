package com.lld.parking.spot;

import com.lld.parking.vehicle.Vehicle;
import com.lld.parking.vehicle.VehicleSize;

public class HeavyVehicleSpot implements  ParkingSpot{
    private int parkingSpotNumber;
    private Vehicle vehicle;

    public HeavyVehicleSpot(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.vehicle = null;
    }


    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void park(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getParkingSpotNumber() {
        return this.parkingSpotNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.LARGE;
    }
}
