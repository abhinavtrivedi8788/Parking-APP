package com.lld.parking.fare;

import com.lld.parking.ticket.Receipt;

import java.math.BigDecimal;

public class NormalFareStrategy implements FareStrategy{

    private static final BigDecimal COMPACT_VEHICLE_FARE = new BigDecimal("5.00");
    private static final BigDecimal NORMAL_VEHICLE_FARE = new BigDecimal("10.00");
    private static final BigDecimal LARGE_VEHICLE_FARE = new BigDecimal("15.00");


    @Override
    public BigDecimal calculateFare(Receipt ticket, BigDecimal basePrice) {
        BigDecimal totalFare = BigDecimal.ZERO;
        BigDecimal rate = BigDecimal.ZERO;
        switch(ticket.getVehicle().getVehicleSize()) {
            case SMALL:
                rate = COMPACT_VEHICLE_FARE;
                break;
            case MEDIUM:
                rate = NORMAL_VEHICLE_FARE;
                break;
            case LARGE:
                rate = LARGE_VEHICLE_FARE;
                break;

        }
        totalFare = totalFare.add(rate.multiply(ticket.calculateParkingTime()));
        return totalFare;
    }
}
