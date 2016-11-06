package ua.edu.ucu.decorator;

abstract class AbstractToppingDecorator implements Pizza {

    protected Pizza toppingPizza;

    public AbstractToppingDecorator(Pizza toppingPizza) {
        this.toppingPizza = toppingPizza;
    }
}
