package com.lld.parking.controller;

import com.lld.parking.dto.VehicleRequest;
import com.lld.parking.orchestrator.ParkingLotOrchestrator;
import com.lld.parking.service.ParkingService;
import com.lld.parking.ticket.Receipt;
import com.lld.parking.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking")
public class ParkingAppController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping
    public ResponseEntity<?> parkVehicle(@RequestBody VehicleRequest vehicle) {
        return new ResponseEntity<>(parkingService.vehicleEntry(vehicle), HttpStatus.OK);
    }
}
