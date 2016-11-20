package ua.edu.ucu.strategy;

public interface IntegralCalculator {
    public double calculate(double start, double end, double step, DoubleFunction func);
    public double calculate();
}
