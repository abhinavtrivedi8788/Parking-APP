package com.lld.parking.fare;

import com.lld.parking.ticket.Receipt;

import java.math.BigDecimal;

public class PeakHourFareStrategy implements  FareStrategy{
    private static final BigDecimal PEAK_HOUR_RATE = BigDecimal.valueOf(100);

    @Override
    public BigDecimal calculateFare(Receipt ticket, BigDecimal basePrice) {
        if(isPeakHour(ticket)){
            return basePrice.multiply(PEAK_HOUR_RATE);
        }
        return basePrice;
    }

    private Boolean isPeakHour(Receipt ticket) {
        int entryTime = ticket.getVehicleEntryTime().getHour();
        return (entryTime >= 8 && entryTime <= 12) || entryTime >= 15 && entryTime <= 19;
    }
}
