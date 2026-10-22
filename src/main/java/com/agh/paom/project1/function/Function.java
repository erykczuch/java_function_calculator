package com.agh.paom.project1.function;

import com.agh.paom.project1.Printable;

public abstract class Function implements Printable {
    public abstract double calculateValue(double x);
    public abstract double[] calculateZeros();
}
