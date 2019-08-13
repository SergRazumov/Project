public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
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
        return 0;
    }
}
