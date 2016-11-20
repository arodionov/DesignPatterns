package ua.edu.ucu.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Andrii_Rodionov
 */
public class IteratorsTest {

    public static void main(String[] args) {

        Iterable<Integer> iterable = SquaringIterator.squaresOf(FibonacciNumbersGenerator.fibonaccis());
        Iterator<Integer> it = iterable.iterator();

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        iterable = SquaringIterator.squaresOf(Arrays.asList(1, 2, 3, 4, 5));
        for (Integer i : iterable) {
            System.out.println(i);
        }

        Iterable<Integer> tenSquaresOfEvenIntegers
                = FirstNIterator.firtsN(
                        SquaringIterator.squaresOf(
                                EvenIterator.evens(
                                        IntegersGenerator.integers()
                                )
                        ),
                        10);

        for (int i : tenSquaresOfEvenIntegers) {
            System.out.println(i);
        }

    }
}
