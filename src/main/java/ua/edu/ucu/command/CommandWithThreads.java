package ua.edu.ucu.command;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import ua.edu.ucu.strategy.IntegralCalculator;
import ua.edu.ucu.strategy.SequentialCalculate;

/**
 *
 * @author Andrii_Rodionov
 */
public class CommandWithThreads {

    static class IntegralCalcRunnable implements Runnable {

        private final IntegralCalculator ic;

        public IntegralCalcRunnable(IntegralCalculator ic) {
            this.ic = ic;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            double result = ic.calculate();
            System.out.println("Finished: result = " + result);
        }
    }

    public static void main(String[] args) {

        IntegralCalculator ic = new SequentialCalculate(0, 100, x -> sin(x) * sin(x) + cos(x) * cos(x));
        IntegralCalcRunnable calcRunnable = new IntegralCalcRunnable(ic);
        Thread thread = new Thread(calcRunnable);
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                long val = -1;
                while ((val % 3571) != 0) {
                    val = System.currentTimeMillis();
                }
                System.out.println("Finished: val = " + val);
            }
        }).start();
    }
}