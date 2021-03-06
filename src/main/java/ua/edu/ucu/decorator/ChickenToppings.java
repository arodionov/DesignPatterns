package ua.edu.ucu.decorator;

public class ChickenToppings extends AbstractToppingDecorator {

    public ChickenToppings(Pizza toppingPizza) {
        super(toppingPizza);
    }

    @Override
    public int getPrice() {
        System.out.println("Chicken");
        return this.toppingPizza.getPrice() + 30;
    }
}
