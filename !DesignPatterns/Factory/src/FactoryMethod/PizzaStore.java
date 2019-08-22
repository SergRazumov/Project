package FactoryMethod;

public abstract class PizzaStore {

    // Абстрактный класс создатель, опеределяет абстрактный фабричный метод, реализуемый субклассами для создания продуктов
    // Часто содержит код зависящий от абстрактного продукта, производимого субклассом, создатель никогда не знает какой продукт будет произведен

    public Pizza orderPizza (String type) {

        Pizza pizza;
        pizza = createPizza(type);

        //  pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

