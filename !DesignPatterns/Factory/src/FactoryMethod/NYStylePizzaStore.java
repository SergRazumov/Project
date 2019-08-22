package FactoryMethod;

public class NYStylePizzaStore extends PizzaStore {

    // Фабричный метод

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new NYStyleCheesePizza();
//        } else if(type.equals("pepperoni")) {
//            return new NYStylePepperoniPizza();
//        } else if(type.equals("veggie")) {
//            return new NYStyleVeggiePizza();
//        } else if(type.equals("clam")) {
//            return new NYStyleClamPizza();
        } else return null;
    }
}
