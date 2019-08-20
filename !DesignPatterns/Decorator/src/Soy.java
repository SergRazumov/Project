public class Soy extends CondimentDecorator {

 //   Beverage beverage;


    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {

        if (beverage.getSize() == Size.TALL) {
            return .20 + beverage.cost();
        } else if (beverage.getSize() == Size.GRANDE) {
            return .15 + beverage.cost();
        } else if (beverage.getSize() == Size.VENTI) {
            return .10 + beverage.cost();
        }
    return beverage.cost();
    }
}
