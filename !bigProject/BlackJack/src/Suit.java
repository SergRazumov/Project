public enum Suit {
    SPADES("пик"), CLUBS("треф"), DIAMONDS("бубей"), HEARTS("червей");

    private String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
