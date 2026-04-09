package com.lld.parking.factory;

import com.lld.parking.dto.VehicleRequest;
import com.lld.parking.vehicle.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle createVehicle(VehicleRequest request) {

        VehicleSize size = VehicleSize.valueOf(request.getSize().toUpperCase());

        return switch (size) {
            case SMALL -> new Bike(request.getLicencePlate());
            case MEDIUM -> new Car(request.getLicencePlate());
            case LARGE -> new Truck(request.getLicencePlate());
            default -> throw new IllegalArgumentException("Unsupported vehicle Size");
        };
    }
}
