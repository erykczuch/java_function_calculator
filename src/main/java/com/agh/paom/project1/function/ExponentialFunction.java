package com.agh.paom.project1.function;

import java.util.Locale;

public class ExponentialFunction extends Function {
    private final double a, b;

    public ExponentialFunction(double a, double b) {
        if (a <= 1e-9 || a < 1 + 1e-9 && a > 1 - 1e-9)
            throw new IllegalArgumentException("a must be greater than 0 and not equal to 1");
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateValue(double x) {
        return Math.pow(a, x) + b;
    }

    @Override
    public double[] calculateZeros() {
        if (b < -1e-9)
            return new double[] {Math.log(-b) / Math.log(a)};
        return new double[0];
    }

    @Override
    public void print() {
        System.out.printf(Locale.US, "Exponential function: f(x) = %.2f^x ", a);
        if (b >= 0) {
            System.out.printf(Locale.US, "+ %.2f\n", b);
        } else {
            System.out.printf(Locale.US, "- %.2f\n", Math.abs(b));
        }

        if (calculateZeros().length == 0) {
            System.out.print("No real zeros\n");
        } else {
            System.out.printf(Locale.US, "Zeros: %.2f", calculateZeros()[0]);
            for (int i = 1; i < calculateZeros().length; i++)
                System.out.printf(Locale.US, ", %.2f", calculateZeros()[i]);
            System.out.print("\n");
        }
    }
}
