public class Card {
    private Cost cost;
    private Suit suit;

    public Card(Cost cost, Suit suit) {
        this.cost = cost;
        this.suit = suit;
    }

    public int getValue() {
        return cost.getValue();
    }

    public String toString() {
        return cost.toString() + " " + suit.toString();
    }
}
