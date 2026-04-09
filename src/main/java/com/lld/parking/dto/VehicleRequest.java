package com.lld.parking.dto;

public class VehicleRequest {
    private String licencePlate;
    private String size; // CAR, BIKE etc.

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
