import java.util.Random;

public class Deck {
    public final static Deck DECK = new Deck();

    private Card[] cards = new Card[52];
    private int count = 52;
    private static Random rnd = new Random();

    public int getCount() {
        return count;
    }

    private Deck() {
        int i = 0;
        for (Cost cost : Cost.values()) {
            for (Suit suit : Suit.values()) {
                cards[i++] = new Card(cost, suit);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(DECK.getCard());
        }
    }

    /**
     * Выдает случайную карту из массива колоды, меняет местами последнюю карту в колоде и ту, которую выдадут, уменьшая
     * count мы не допускаем того чтобы брались те карты которые перемещены наверх
     * @return случайную карту из массива колоды
     */
    public Card getCard() {
        int i = rnd.nextInt(count);
        Card c = cards[i];
        cards[i] = cards[--count];
        cards[count] = c;
        return c;
    }
}
