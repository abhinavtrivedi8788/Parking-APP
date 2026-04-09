package com.lld.parking.vehicle;

public class Bike implements Vehicle {
    String licencePlate;

    Bike(String licencePlate) {
        this.licencePlate = licencePlate;
    }


    @Override
    public String getVehicleLicenceNumber() {
        return this.licencePlate;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }
}
