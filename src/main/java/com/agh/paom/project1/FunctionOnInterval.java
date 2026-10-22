package com.agh.paom.project1;

import com.agh.paom.project1.function.Function;

import java.util.Locale;

public class FunctionOnInterval implements Printable {
    private final Function function;
    private final double intervalStart, intervalEnd, step, intervalLength;

    public FunctionOnInterval(Function function, double intervalStart, double intervalEnd, double step) {
        if (intervalEnd-intervalStart <= 0)
            throw new IllegalArgumentException("End of interval must be greater than start of interval");
        if (step <= 0)
            throw new IllegalArgumentException("Step must be greater than 0");
        if (step > intervalEnd-intervalStart)
            throw new IllegalArgumentException("Step must be less than the length of the interval");
        if (function == null)
            throw new IllegalArgumentException("Function cannot be null");
        this.function = function;
        this.intervalLength = intervalEnd - intervalStart;
        this.intervalStart = intervalStart;
        this.intervalEnd = intervalEnd;
        this.step = step;
    }

    public double[] calculateValues() {
        int count = (int) Math.floor(intervalLength / step + 1e-9) + 1;
        double[] values = new double[count];

        for (int i = 0; i < count; i += 1) {
            values[i] = function.calculateValue(intervalStart + i*step);
        }
        return values;
    }

    public double[] minMax() {
        double[] values = calculateValues();
        double[] minMaxValues = new double[2]; // minMaxValues[0] - minimum     minMaxValues[1] - maximum
        minMaxValues[0] = minMaxValues[1] = values[0];

        for (int i = 1; i < values.length; i += 1) {
            if(minMaxValues[0] > values[i])
                minMaxValues[0] = values[i];
            if(minMaxValues[1] < values[i])
                minMaxValues[1] = values[i];
        }
        return minMaxValues;
    }

    public double calculateArea() {
        double area = 0;
        int count = (int) Math.floor(intervalLength / step + 1e-9) + 1;

        for (int i = 0; i < count-1; i += 1) {
            area += (function.calculateValue(intervalStart + i * step)
                    + function.calculateValue(intervalStart + (i + 1) * step)) / 2 * step;
        }
        return area;
    }

    @Override
    public void print() {
        int count = (int) Math.floor(intervalLength / step + 1e-9) + 1;
        function.print();

        System.out.printf(Locale.US,
                "Function on interval: [%.2f, %.2f] with step %.2f\n", intervalStart, intervalEnd, step);
        System.out.print("x:\t\t");

        for (int i = 0; i < count; i += 1)
            System.out.printf(Locale.US, "%8.2f", intervalStart + i*step);

        System.out.print("\n");

        System.out.print("f(x):\t");

        for (int i = 0; i < count; i += 1)
            System.out.printf(Locale.US, "%8.2f", calculateValues()[i]);

        System.out.print("\n");

        System.out.printf(Locale.US, "Minimum: %.2f\tMaximum: %.2f\n", minMax()[0], minMax()[1]);
        System.out.printf(Locale.US, "Area (Trapezoidal rule): %.2f\n", calculateArea());
    }
}
