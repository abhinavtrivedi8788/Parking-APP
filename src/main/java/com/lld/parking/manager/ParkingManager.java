package com.lld.parking.manager;

import com.lld.parking.spot.ParkingSpot;
import com.lld.parking.vehicle.Vehicle;
import com.lld.parking.vehicle.VehicleSize;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abhinavtrivedi - 2024-06-17
 * ParkingManager is responsible for managing the parking spots and vehicles in the parking lot.
 */

@Component
public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> sizeSpotMapping;
    private final Map<Vehicle, ParkingSpot> vehicleSpotMapping;

    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots){
        this.sizeSpotMapping = availableSpots;
        this.vehicleSpotMapping = new HashMap<>();
    }

    public ParkingSpot fetchAvailableSpot(Vehicle vehicle) {
        VehicleSize vehicleForParking =vehicle.getVehicleSize();
        for(VehicleSize size: VehicleSize.values()){
            if(size.ordinal() >= vehicleForParking.ordinal()){
                List<ParkingSpot> parkingSpots = sizeSpotMapping.get(size);
                for(ParkingSpot spot: parkingSpots){
                    if(spot.isAvailable()){
                        return spot;
                    }
                }
            }

        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spotForParking = fetchAvailableSpot(vehicle);
        if(spotForParking != null){
            vehicleSpotMapping.put(vehicle, spotForParking);
            sizeSpotMapping.get(spotForParking.getVehicleSize()).remove(spotForParking);
            return spotForParking;
        }
        return null;
    }

    public void unparkVehicle(Vehicle vehicle) {
        ParkingSpot parkedSpot = vehicleSpotMapping.remove(vehicle);
        if(parkedSpot != null){
            parkedSpot.vacate();
            sizeSpotMapping.get(parkedSpot.getVehicleSize()).add(parkedSpot);
        }
    }

    public ParkingSpot locateVehicle(Vehicle vehicle) {
        return vehicleSpotMapping.get(vehicle);
    }

}
