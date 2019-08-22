package SimpleFactory;

public class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Подготовка пиццы пеперони");
    }

    @Override
    public void bake() {
        System.out.println("Пепперони пицца испечена");
    }

    @Override
    public void cut() {
        System.out.println("Пепперони пицца порезана");
    }

    @Override
    public void box() {
        System.out.println("Пепперони пицца упакована");
    }
}
