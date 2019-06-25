public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.print("Без звука..");
    }
}
