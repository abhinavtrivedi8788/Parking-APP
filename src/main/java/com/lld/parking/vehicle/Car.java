package com.lld.parking.vehicle;

public class Car implements Vehicle {
    String licencePlate;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String getVehicleLicenceNumber() {
        return this.licencePlate;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.MEDIUM;
    }
}
