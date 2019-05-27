package generating;

import java.util.stream.Stream;

public class FromIterator {
    public static void main(String[] args) {
        Stream.iterate(5, x -> 3 * x).parallel().limit(10).forEach(System.out::println);
    }
}
