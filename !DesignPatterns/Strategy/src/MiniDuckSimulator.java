public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior (new FlyRocketPowered());
        model.performFly();
        ManokDuck manokDuck = new ManokDuck();
        manokDuck.performQuack();
        manokDuck.performFly();
        manokDuck.setQuackBehavior(new Squeak());
        manokDuck.performQuack();
    }
}
