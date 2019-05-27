package collecting;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap {
    public static void main(String[] args) {
        String list = "Иванов  Петров Сидоров  Санников  Иванников  Пушкин  Грибоедов  Серов";
        Map<Character, Integer> counter =
                Stream.of(list.split("\\s+"))
                        .collect(Collectors.toMap(s -> s.charAt(0), c->1, (x, y)-> x+y));
        System.out.println(counter);
        SortedMap<Character, Integer> sortedCounter = new TreeMap<>(counter);
        System.out.println(sortedCounter);
    }
}
