package ua.edu.ucu.template_method;

import static java.lang.Math.*;

public abstract class SequentialCalculate {

    public double calculate(double start, double end, double step) {
        double result = 0.0;
        double x = start;
        while (x < end) {
            result += step * f(x);
            x += step;
        }
        return result;
    }

    // Template method
    protected abstract double f(double x);

    public static void main(String[] args) {
        final double STEP = 0.0001;
        double res;
        res = new SinCosCalc().calculate(0, 10, STEP);
        System.out.println(res);

        res = new OneCalc().calculate(0, 10, STEP);
        System.out.println(res);
    }
}

class SinCosCalc extends SequentialCalculate {

    @Override
    public double f(double x) {
        return sin(x) + cos(x);
    }
}

class OneCalc extends SequentialCalculate {

    @Override
    public double f(double x) {
        return 1;
    }
}
