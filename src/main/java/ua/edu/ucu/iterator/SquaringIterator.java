package ua.edu.ucu.iterator;

import java.util.Iterator;

/**
 *
 * @author Andrii_Rodionov
 */
public class SquaringIterator implements Iterator<Integer> {

    private final Iterator<Integer> iter;

    public SquaringIterator(Iterator<Integer> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Integer next() {
        int value = iter.next();
        return value * value;
    }

    @Override
    public void remove() {
        iter.remove();
    }

    public static Iterable<Integer> squaresOf(final Iterable<Integer> seq) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new SquaringIterator(seq.iterator());
            }
        };
    }
}
