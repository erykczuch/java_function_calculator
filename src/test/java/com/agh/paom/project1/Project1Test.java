package com.agh.paom.project1;

import com.agh.paom.project1.function.LinearFunction;
import com.agh.paom.project1.function.QuadraticFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Project1Test {

    @Test
    void linearFunctionZeroAndValue() {
        LinearFunction function = new LinearFunction(2, -4);

        assertEquals(2.0, function.calculateZeros()[0], 1e-9);
        assertEquals(0.0, function.calculateValue(2), 1e-9);
    }

    @Test
    void quadraticFunctionRejectsZeroA() {
        assertThrows(IllegalArgumentException.class, () -> new QuadraticFunction(0, 1, 1));
    }

    @Test
    void intervalSamplesAndTrapezoidalArea() {
        FunctionOnInterval interval = new FunctionOnInterval(new LinearFunction(1, 0), 0, 2, 1);

        assertArrayEquals(new double[]{0, 1, 2}, interval.calculateValues(), 1e-9);
        assertEquals(2.0, interval.calculateArea(), 1e-9);
    }
}
