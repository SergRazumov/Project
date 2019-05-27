package generating;

import java.time.LocalTime;
import java.util.stream.Stream;

public class FromGenerator {
    public static void main(String[] args) {
        Stream.generate(() -> LocalTime.now()).limit(10).forEach(System.out::println);
    }
}
