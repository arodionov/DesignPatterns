package ua.edu.ucu.iterator;

import java.util.Iterator;

public class EvenIterator implements Iterator<Integer> {

    private final Iterator<Integer> iter;

    public EvenIterator(Iterator<Integer> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Integer next() {
        int value = iter.next();
        if(value % 2 != 0) {
            //next();
            value  = next();
        }
        return value;
    }

    public static Iterable<Integer> evens(final Iterable<Integer> seq) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new EvenIterator(seq.iterator());
            }
        };
    }
    
    public static void main(String[] args) {
        Iterable<Integer> integers = 
                SquaringIterator.squaresOf(
                        EvenIterator.evens(
                                IntegersGenerator.integers()
                        )
                );
        
        for (Iterator<Integer> it = integers.iterator(); it.hasNext();) {
            int i = it.next();
            System.out.println(i);
        }
    }
}
