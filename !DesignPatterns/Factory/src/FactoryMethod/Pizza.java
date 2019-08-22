package FactoryMethod;

import java.util.ArrayList;

// Фабрики производят продукты, у класса PizzaStore продукт это Pizza

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void bake() {
        System.out.println("Bake for 25 min at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza diagonal");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
