package com.agh.paom.project1.function;

import java.util.Locale;

public class LinearFunction extends Function {
    private final double a, b;

    public LinearFunction(double a, double b) {
        if (Math.abs(a) < 1e-9)
            throw new IllegalArgumentException("a cannot be 0");
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculateValue(double x) {
        return (a * x) + b;
    }

    @Override
    public double[] calculateZeros() {
        return new double[] {-b/a};
    }

    @Override
    public void print() {
        System.out.printf(Locale.US, "Linear function: f(x) = %.2fx ", a);
        if (b >= 1e-9) {
            System.out.printf(Locale.US, "+ %.2f\n", b);
        }
        else {
            System.out.printf(Locale.US, "- %.2f\n", Math.abs(b));
        }

        if (calculateZeros().length == 0)
            System.out.print("No real zeros\n");
        else {
            System.out.printf(Locale.US, "Zeros: %.2f", calculateZeros()[0]);
            for (int i = 1; i < calculateZeros().length; i++)
                System.out.printf(Locale.US, ", %.2f", calculateZeros()[i]);
            System.out.print("\n");
        }
    }
}
