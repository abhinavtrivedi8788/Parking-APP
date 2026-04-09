package com.lld.parking.fare;

import java.util.List;

public class FareCalculation {
    private List<FareStrategy> fareStrategies;
    public FareCalculation(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }
}
