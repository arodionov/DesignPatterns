package ua.edu.ucu.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Andrii_Rodionov
 */
public class IntegersGenerator implements Iterator<Integer>{

    private int i = 0;
    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return i++;
    }
    
    public static Iterable<Integer> integers() {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new IntegersGenerator();
            }
        };
    }    
    
    public static void main(String[] args) {
        Iterable<Integer> defined = Arrays.asList(1, 2, 3, 4, 5);        
        for(int i : defined) {
            System.out.println(i);
        }
        
        Iterable<Integer> generated = IntegersGenerator.integers();
        for(int i : generated) {
            System.out.println(i);
        }
    }
}
