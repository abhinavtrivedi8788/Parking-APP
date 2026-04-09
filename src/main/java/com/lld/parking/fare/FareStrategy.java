package com.lld.parking.fare;

import com.lld.parking.ticket.Receipt;

import java.math.BigDecimal;

public interface FareStrategy {

    BigDecimal calculateFare(Receipt ticket, BigDecimal basePrice);
}
