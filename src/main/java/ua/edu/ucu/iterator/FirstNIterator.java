package ua.edu.ucu.iterator;

import java.util.Iterator;

public class FirstNIterator implements Iterator<Integer> {

    private final Iterator<Integer> iter;
    private final int N;
    private int count;

    public FirstNIterator(Iterator<Integer> iter, int N) {
        this.iter = iter;
        this.N = N;
    }

    @Override
    public boolean hasNext() {
        return (count < N) && iter.hasNext();
    }

    @Override
    public Integer next() {
        int value = iter.next();
        count++;
        return value;
    }

    public static Iterable<Integer> firtsN(final Iterable<Integer> seq, int N) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new FirstNIterator(seq.iterator(), N);
            }
        };
    }

    public static void main(String[] args) {
        Iterable<Integer> integers
                = FirstNIterator.firtsN(
                        IntegersGenerator.integers(),
                        10
                );

        for (int i : integers) {
            System.out.println(i);
        }
    }
}
