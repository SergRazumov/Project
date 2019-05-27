package generating;

import java.util.stream.Stream;

public class FromArray {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(new Integer[] { 2, 4, 7, 3, 1, 5, 9});
        s.sorted().forEach(System.out::println);
    }
}
