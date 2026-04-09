package com.lld.parking.parkingspot;

import com.lld.parking.vehicle.Vehicle;
import com.lld.parking.vehicle.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();
    void park(Vehicle  vehicle);
    void vacate();
    int getParkingSpotNumber();
    VehicleSize  getVehicleSize();
}
