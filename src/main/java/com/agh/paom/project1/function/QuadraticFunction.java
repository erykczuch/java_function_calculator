package com.agh.paom.project1.function;

import java.util.Locale;

public class QuadraticFunction extends Function {
    private final double a, b, c;

    public QuadraticFunction(double a, double b, double c) {
        if (Math.abs(a) < 1e-9) {
            throw new IllegalArgumentException("a cannot be 0");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateValue(double x) {
        return (a * x * x) + (b * x) + c;
    }

    private double calculateDelta() {
        return b * b - 4 * a * c;
    }

    private double[] calculateVertex() {
        double vertexX = -b / (2 * a);
        double vertexY = calculateValue(vertexX);

        return new double[]{vertexX, vertexY};
    }

    @Override
    public double[] calculateZeros() {
        double delta = calculateDelta();

        if (Math.abs(delta) < 1e-9) {
            return new double[] { -b / (2 * a) };
        }

        if (delta < 0) {
            return new double[0];
        }

        return new double[] {
                (-b + Math.sqrt(delta)) / (2 * a),
                (-b - Math.sqrt(delta)) / (2 * a)
        };
    }

    @Override
    public void print() {
        System.out.printf(Locale.US, "Quadratic function: f(x) = %.2fx^2 ", a);
        if (b >= 0)
            System.out.printf(Locale.US, "+ %.2fx ", b);
        else
            System.out.printf(Locale.US, "- %.2fx ", Math.abs(b));

        if (c >= 0)
            System.out.printf(Locale.US, "+ %.2f\n", c);
        else
            System.out.printf(Locale.US, "- %.2f\n", Math.abs(c));

        System.out.printf(Locale.US, "Delta: %.2f\n", calculateDelta());

        System.out.printf(Locale.US, "Vertex: (%.2f", calculateVertex()[0]);
        for (int i = 1; i < calculateVertex().length; i++)
            System.out.printf(Locale.US, ", %.2f", calculateVertex()[i]);
        System.out.print(")\n");

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