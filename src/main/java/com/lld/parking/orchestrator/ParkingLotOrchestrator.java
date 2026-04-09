package com.lld.parking.orchestrator;

import com.lld.parking.fare.FareCalculation;
import com.lld.parking.manager.ParkingManager;
import com.lld.parking.spot.ParkingSpot;
import com.lld.parking.ticket.Receipt;
import com.lld.parking.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ParkingLotOrchestrator {

    private ParkingManager  parkingManager;
    private FareCalculation fareCalculation;

    public ParkingLotOrchestrator(ParkingManager parkingManager,
                                  FareCalculation fareCalculation) {
        this.parkingManager = parkingManager;
        this.fareCalculation = fareCalculation;
    }

    public Receipt vehicleEntry(Vehicle vehicle) {
        ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
        if(parkingSpot != null){
            Receipt receipt = new Receipt(generateReceiptId(), vehicle, parkingSpot, java.time.LocalDateTime.now());
            receipt.setVehicle(vehicle);
            receipt.setVehicleEntryTime(java.time.LocalDateTime.now());
            return receipt;
        }
        return null;
    }

    public Receipt vehicleExit(Receipt receipt) {
        if(receipt != null && receipt.getVehicleExitTime() == null){
            receipt.setVehicleExitTime(java.time.LocalDateTime.now());
            parkingManager.unparkVehicle(receipt.getVehicle());
            BigDecimal totalFare = fareCalculation.calculateFare(receipt);
            receipt.setTollPrice(totalFare);
            return receipt;
        }
        return null;
    }

    // Helper method to generate a unique ticket ID
     String generateReceiptId() {
        return "RECEIPT-" + System.currentTimeMillis();
    }
}
