package collecting;

import java.util.stream.Stream;

public class Count {
    public static void main(String[] args) {
        String list = "Иванов  Петров Сидоров  Санников  Иванников  Пушкин  Грибоедов  Серов";
        long count = Stream.of(list.split("\\s+")).count();
        System.out.println(count);
    }
}
