package ua.edu.ucu.decorator;

public class PizzaTest {

    public static void main(String[] args) {

        // Pizza with chicken and double cheese
        Pizza pizza = new CheeseToppings(new CheeseToppings(new ChickenToppings(new PlainPizza())));
        System.out.println(pizza.getPrice());
    }

}
