package ua.edu.ucu.decorator;

public class PlainPizza implements Pizza {

    @Override
    public int getPrice() {
        System.out.println("Plain Pizza");
        return 50;
    }
}
