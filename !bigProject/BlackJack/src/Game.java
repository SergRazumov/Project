public class Game {
    public static void run() {
        Player human = new Player(new HumanStrategy());
        CompStrategy strategy = new CompStrategy();
        Player comp = new Player(strategy);
        strategy.init(comp);
        for (int i = 0; i < 2; i++) {
            human.addCard();
            comp.addCard();
        }
        System.out.println(human);

        while (human.getValue() < 20 && human.toGet(human.getHand(),comp.getCount())) {
            human.addCard();
            System.out.println(human);
        }
        if (human.getValue() > 21) {
            System.out.println("Проиграли!");
        } else if (human.getValue() == 21) {
            System.out.println("Выиграли!");
        } else {
            while (comp.getValue() < 20 && comp.toGet(comp.getHand(),comp.getCount())) {
                comp.addCard();
            }
            System.out.println("У меня ");
            System.out.println(comp);
            if (comp.getValue() > 21) {
                System.out.println("Увы! Я проиграл!");
            } else if (comp.getValue() == 21) {
                System.out.println("Ура! Я выиграл!");
            } else if (human.getValue() > comp.getValue()) {
                System.out.println("У вас больше... Выиграли");
            } else {
                System.out.println("У меня больше! Я выиграл");
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
