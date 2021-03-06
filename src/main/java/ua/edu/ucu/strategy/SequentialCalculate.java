package ua.edu.ucu.strategy;

import static java.lang.Math.*;

class SinFunc implements DoubleFunction {

    @Override
    public double apply(double x) {
        return sin(x);
    }
}

public class SequentialCalculate implements IntegralCalculator {

    private double start;
    private double end;
    private final double step = 0.00001;
    private DoubleFunction func;

    public SequentialCalculate() {
    }  
    
    public SequentialCalculate(double start, double end, DoubleFunction func) {
        this.start = start;
        this.end = end;
        this.func = func;
    }   
    
    @Override
    public double calculate() {
        return calculate(start, end, step, func);
    }

    @Override
    public double calculate(double start, double end, double step, DoubleFunction func) {
        double result = 0.0;
        double x = start;
        while (x < end) {
            result += step * func.apply(x);
            x += step;
        }
        return result;
    }

    public static void main(String[] args) {
        final double STEP = 0.0001;
        double res;
        res = new SequentialCalculate().calculate(0, 10, STEP, new SinFunc());
        System.out.println(res);

        // With anonymous class
        res = new SequentialCalculate().calculate(0, 10, STEP,
                new DoubleFunction() {
            @Override
            public double apply(double x) {
                return sin(x) * sin(x) + cos(x) * cos(x);
            }
        }
        );
        System.out.println(res);

        // With Java 8 lambdas
        res = new SequentialCalculate().calculate(0, 10, STEP, x -> sin(x) * sin(x) + cos(x) * cos(x));
        System.out.println(res);
    }

}
