package com.lld.parking.fare;

import com.lld.parking.ticket.Receipt;

import java.math.BigDecimal;
import java.util.List;

public class FareCalculation {
    private List<FareStrategy> fareStrategies;
    public FareCalculation(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    public BigDecimal calculateFare(Receipt receipt) {
        BigDecimal tollforParking = BigDecimal.ZERO;
        for (FareStrategy strategy : fareStrategies) {
            tollforParking= strategy.calculateFare(receipt, tollforParking);
        }
        return tollforParking;
    }
}
