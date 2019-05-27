public enum Cost {
    CARD2("Двойка", 2),
    CARD3("Тройка", 3),
    CARD4("Четверка", 4),
    CARD5("Пятерка", 5),
    CARD6("Шестерка", 6),
    CARD7("Семерка", 7),
    CARD8("Восьмерка", 8),
    CARD9("Девятка", 9),
    CARD10("Десятка", 10),
    JACK("Валет", 2),
    QUEEN("Дама", 3),
    KING("Король", 4),
    ACE("Туз", 11);
    private String name;
    private int value;

    Cost(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
