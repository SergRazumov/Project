package generating;

import java.util.stream.Stream;

public class FromSequence {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(2, 4, 7, 3, 1, 5, 9);
        s.forEach(System.out::println);
        System.out.println();
        s = Stream.of(2, 4, 7, 3, 1, 5, 9);
        s.parallel().forEach(System.out::println);
        System.out.println();
        s = Stream.of(2, 4, 7, 3, 1, 5, 9);
        s.sorted().forEach(System.out::println);
    }
}
