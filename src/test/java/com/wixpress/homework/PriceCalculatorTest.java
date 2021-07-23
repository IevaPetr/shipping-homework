package com.wixpress.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {


    @Test
    public void testPriceCalculation() {
        final PriceCalculator priceCalculator = new PriceCalculator();

        assertEquals("2021-07-15 S LP 1.23", priceCalculator.getPrice("2021-07-15 S LP"));
        assertEquals("2021-02-30 M DH ERROR", priceCalculator.getPrice("2021-02-30 M DH"));   //feb 30th doesn't exist
        assertEquals("2021-02-30 L DH ERROR", priceCalculator.getPrice("2021-02-30 L DH"));   //DH doesn't have L size
        assertEquals("2018-04-31 M DH ERROR", priceCalculator.getPrice("2018-04-31 M DH"));   //april 31st doesn't exist
        assertEquals("2021-06-30 L LP 7", priceCalculator.getPrice("2021-06-30 L LP"));
        assertEquals("2020-01-01 M DH 3.40", priceCalculator.getPrice("2020-01-01 M DH"));
        assertEquals("2020-01-01 M LD ERROR", priceCalculator.getPrice("2020-01-01 M LD"));   //wrong provider
    }
}