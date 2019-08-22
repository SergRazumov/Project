package SimpleFactory;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("pepperoni")) {
            pizza  = new PepperoniPizza();
        } else if(type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
