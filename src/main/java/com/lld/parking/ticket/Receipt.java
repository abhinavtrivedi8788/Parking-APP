package com.lld.parking.ticket;

import com.lld.parking.spot.ParkingSpot;
import com.lld.parking.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Receipt {
    private String receiptId;
    private Vehicle vehicle;
    private ParkingSpot  parkingSpot;
    private LocalDateTime vehicleEntryTime;
    private LocalDateTime vehicleExitTime;

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getVehicleEntryTime() {
        return vehicleEntryTime;
    }

    public void setVehicleEntryTime(LocalDateTime vehicleEntryTime) {
        this.vehicleEntryTime = vehicleEntryTime;
    }

    public LocalDateTime getVehicleExitTime() {
        return vehicleExitTime;
    }

    public void setVehicleExitTime(LocalDateTime vehicleExitTime) {
        this.vehicleExitTime = vehicleExitTime;
    }

    public BigDecimal calculateParkingTime() {
        return BigDecimal.valueOf(
                java.time.Duration.between(
                        vehicleEntryTime, vehicleExitTime)
                        .toMinutes());
    }
}
