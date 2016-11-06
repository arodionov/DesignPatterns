package ua.edu.ucu.decorator;

abstract class ToppingDecorator implements Pizza {

    protected Pizza toppingPizza;

    public ToppingDecorator(Pizza toppingPizza) {
        this.toppingPizza = toppingPizza;
    }
}
