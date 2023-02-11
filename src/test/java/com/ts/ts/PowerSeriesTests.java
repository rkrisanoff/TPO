package com.ts.ts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerSeriesTests {
    @ParameterizedTest(name = "arctg({0})")
    @DisplayName("Check Dots")
    @ValueSource(doubles = {0,1/6d,1/3d,1/2d,2/3d,5/6d,1d})
    void checkPiDots(double param) {
        assertAll(
                () -> assertEquals(Math.atan(param), PowerSeries.calculateArctg(param, 1000), 0.001d)
        );
    }

    @ParameterizedTest(name = "arctg({0}) = {1}")
    @DisplayName("Check between dots [-1; 1]")
    @CsvFileSource(resources = "/arctg.csv", numLinesToSkip = 1, delimiter = ';')
    void checkBetweenDotsMinusPiAndPi(double x, double y) {
        assertAll(
                () -> assertEquals(y, PowerSeries.calculateArctg(x, 10000), 0.001d)
        );
    }
}
