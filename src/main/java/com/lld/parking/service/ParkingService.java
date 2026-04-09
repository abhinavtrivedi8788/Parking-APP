package com.lld.parking.service;

import com.lld.parking.dto.VehicleRequest;
import com.lld.parking.factory.VehicleFactory;
import com.lld.parking.orchestrator.ParkingLotOrchestrator;
import com.lld.parking.ticket.Receipt;
import com.lld.parking.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    @Autowired
    private ParkingLotOrchestrator parkingLotOrchestrator;

    @Autowired
    private VehicleFactory vehicleFactory;

    public ResponseEntity<?> vehicleEntry(VehicleRequest vehicleDTO) {
        Vehicle vehicle = vehicleFactory.createVehicle(vehicleDTO);
        Receipt receipt = parkingLotOrchestrator.vehicleEntry(vehicle);
        return ResponseEntity.ok().body(receipt);
    }
}
