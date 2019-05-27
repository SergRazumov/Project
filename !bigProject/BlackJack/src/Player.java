public class Player {
    private Card[] hand = new Card[11];
    private int count = 0;
    private Strategy strategy;

    public Player(Strategy str) {
        strategy = str;
    }

    public Card[] getHand() {
        return hand;
    }

    public int getCount() {
        return count;
    }

    /**
     * Запускает метод из класса HumanStrategy или CompStrategy в зависимости от типа объекта запускаемого с toGet
     * @param hand
     * @param count
     * @return
     */
    public boolean toGet(Card[] hand, int count) {
        return strategy.toGet();
    }

    /**
     * Добавить карту в массив карт в руке
     */

    public void addCard() {
        hand[count++] = Deck.DECK.getCard();//т.е мы обращаемся из другого класса по имени статического объекта
    }

    /**
     * Выдает строковое представление игрока:
     * - количество картж
     * - сами картыж
     * - общая стоимость всех карт
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Всего " + count + " карт\n");
        for (int i = 0; i < count; i++) {
            sb.append(hand[i].toString()).append('\n');
        }
        sb.append("Суммарная стоимость карт ").append(getValue());
        return sb.toString();
    }

    /**
     * Подсчитывает стоимость тех карт, которые в руке
     * @return если два туза вернет значение 21, либо значение тех карт что в руке
     */
    public int getValue() {
        int value = 0;
        for (int i = 0; i < count; i++) {
            value += hand[i].getValue();
        }
        return value == 22 && count == 2 ? 21 : value;
    }

    public static void main(String[] args) {
        Player p = new Player(new HumanStrategy());
        for (int i = 0; i < 11; i++) {
            p.addCard();
        }
        System.out.println(p);
    }
}
