package ua.edu.ucu.iterator;

import java.util.Iterator;

/**
 *
 * @author Andrii_Rodionov
 */
public class FibonacciNumbersGenerator implements Iterator<Integer> {

    private int val1 = 0;
    private int val2 = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int x = val2;
        val2 = val1 + val2;
        val1 = x;
        return val1;
    }

    public static Iterable<Integer> fibonaccis() {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new FibonacciNumbersGenerator();
            }
        };
    }
}
