package collecting;

import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        String list = "Иванов  Петров Сидоров  Санников  Иванников  Пушкин  Грибоедов  Серов";
        String reduced1 = Stream.of(list.split("\\s+")).reduce((s1, s2) -> s1 + " - " + s2).get();
        System.out.println(reduced1);
        String reduced2 = Stream.of(list.split("\\s+")).reduce("", (s1, s2) -> s1 + " - " + s2);
        System.out.println(reduced2.substring(3));
        String reduced3 = Stream.of(list.split("\\s+")).parallel().reduce("", (s1, s2) -> s1 + "," + s2);
        System.out.println(reduced3);
    }
}
