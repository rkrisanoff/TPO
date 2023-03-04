package com.ts.ts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PowerSeriesTests {
    @ParameterizedTest
    @DisplayName("Check definition area")
    @ValueSource(doubles = {-1d, -0.83d, -0.66d, -0.5d, -0.33d, -0.16d, 0, 0.16d, 0.33d, 0.5d, 0.66d, 0.83d, 1d})
    void testDefinitionArea(double arg) {
        assertAll(
                () -> assertEquals(Math.atan(arg), PowerSeries.calculateArctg(arg, 1000), 0.001d)
        );
    }

    @ParameterizedTest
    @DisplayName("Check definition area")
    @ValueSource(doubles = {-Double.MAX_VALUE, -2, -1.0001, 1.0001, 2d, Double.MAX_VALUE})
    void testDefinitionAreaOut(double arg) {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> PowerSeries.calculateArctg(arg, 1000))
        );
    }

    @ParameterizedTest
    @DisplayName("Check oddness")
    @ValueSource(doubles = {-1, -0.83d, -0.66d, -0.5d, -0.33d, -0.16d, 0, 0.16d, 0.33d, 0.5d, 0.66d, 0.83d, 1d})
    void testOddness(double arg) {
        assertAll(
                () -> assertEquals(
                        PowerSeries.calculateArctg(arg, 1000),
                        -PowerSeries.calculateArctg(-arg, 1000),
                        0.001d)
        );
    }

    @ParameterizedTest
    @DisplayName("Check monotonicity")
    @CsvFileSource(resources = "/arctg.csv", numLinesToSkip = 1, delimiter = ';')
    void testMonotonicity(double arg1, double arg2) {
        assertAll(
                () -> assertTrue(
                        PowerSeries.calculateArctg(arg1, 1000) < PowerSeries.calculateArctg(arg2, 1000))

        );
    }

}
