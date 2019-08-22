package SimpleFactory;

public class CheesePizza implements Pizza {

     public void prepare() {
         System.out.println("Заготовка теста");
     }

    public void bake() {
        System.out.println("Сарная пицца испечена");
    }

    public void cut() {
        System.out.println("Сырная пицца порезана");
    }

    public void box() {
        System.out.println("Сырная пицца упакована");
    }
}
