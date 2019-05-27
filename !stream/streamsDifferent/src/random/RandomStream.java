package random;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomStream {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        Stream<String> ints1 = rnd.ints().limit(10).mapToObj(String::valueOf);
        System.out.println(ints1.reduce((n1, n2) -> n1 + " " + n2).get());

        Stream<String> ints2 = rnd.ints(10, 20, 50).mapToObj(String::valueOf);
        System.out.println(ints2.reduce((n1, n2) -> n1 + " " + n2).get());
    }
}
