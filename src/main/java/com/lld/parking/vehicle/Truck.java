package com.lld.parking.vehicle;

public class Truck implements Vehicle{
    String licencePlate;

    public Truck(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String getVehicleLicenceNumber() {
        return this.licencePlate;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.LARGE;
    }
}
