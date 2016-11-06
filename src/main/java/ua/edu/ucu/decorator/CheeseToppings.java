package ua.edu.ucu.decorator;

public class CheeseToppings extends ToppingDecorator {

    public CheeseToppings(Pizza toppingPizza) {
        super(toppingPizza);
    }

    @Override
    public int getPrice() {
        System.out.println("Cheese");
        return this.toppingPizza.getPrice() + 20;
    }
}
